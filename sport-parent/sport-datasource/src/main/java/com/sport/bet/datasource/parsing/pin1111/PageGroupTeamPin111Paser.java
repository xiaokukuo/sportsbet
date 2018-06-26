package com.sport.bet.datasource.parsing.pin1111;

import java.util.ArrayList;
import java.util.List;

import org.htmlcleaner.HtmlCleaner;
import org.htmlcleaner.TagNode;
import org.htmlcleaner.XPatherException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.sport.bet.bean.model.SportGameOdds;
import com.sport.bet.bean.model.SportModuleGame;
import com.sport.bet.common.utils.HttpTool;
import com.sport.bet.datasource.parsing.AbstractPaser;
import com.sport.bet.datasource.parsing.bet365.PageGroupTeamPaser;

@Component
public class PageGroupTeamPin111Paser extends AbstractPaser<SportGameOdds> {

	Logger logger = LoggerFactory.getLogger(PageGroupTeamPaser.class);
	
	private static String urlPre = "https://www.pin1111.com/webapi/1.17/api/v1/GuestLines/Deadball/";
	private static String urlEnd = "?callback=angular.callbacks._0"; 
	
	private List<SportModuleGame> moduleGameList = new ArrayList<SportModuleGame>();

	@Override
	public List<SportGameOdds> parsed(String pageJson) {
		SportGameOdds sportGameOdds = null;
		
		HtmlCleaner hc = new HtmlCleaner();
		TagNode tn = hc.clean(pageJson);
		String xpath = "//div[@ng-controller='GuestLinesController']";
		
		String ngInit = null;
		try {
			TagNode divtn  = (TagNode) tn.evaluateXPath(xpath)[0];
			ngInit = divtn.getAttributeByName("ng-init").substring(5);
		} catch (XPatherException e) {
			e.printStackTrace();
		}
		
		
		String[] arr = ngInit.split(",");
		String newurl =  urlPre + arr[0].trim() + "/" + arr[1].trim() + urlEnd;
		
		String gameJson = HttpTool.getSportPin111(newurl); // 获取模块下比赛数据
		gameJson = gameJson.substring(gameJson.indexOf("{"), gameJson.indexOf(");"));
		
		JSONObject jsonObj = (JSONObject) JSONObject.parse(gameJson);
		JSONArray leaguesArray = jsonObj.getJSONArray("Leagues");
		
		JSONObject leagueJsonObj = null;
		JSONArray  eventsArray = null;
		JSONObject eventJsonObj = null;
		String teamName1 = null;
		String teamName2 = null;
		
		String leagueId = null; // 模块ID
		
		JSONObject handicapObj = null;
		
		SportModuleGame sportModuleGame = null;
		
		for (Object leagueObj : leaguesArray) {
			leagueJsonObj= (JSONObject) leagueObj;
			leagueId = eventJsonObj.getString("LeagueId");
			eventsArray = leagueJsonObj.getJSONArray("Events");
			String eventId = null;
			for (Object eveObj : eventsArray) {
				sportModuleGame = new SportModuleGame();
				
				eventJsonObj = (JSONObject) eveObj;
				eventId = eventJsonObj.getString("EventId"); // 队伍ID
				
				//让分信息
				JSONArray  participants = eventJsonObj.getJSONArray("Participants");
				for (Object participant : participants) {
					JSONObject particObj = (JSONObject) participant;
					sportGameOdds = new SportGameOdds();
					sportGameOdds.setCid(leagueId);
					sportGameOdds.setEid(eventId);
					
					if(particObj.getBoolean("IsDraw")){
						sportGameOdds.setScoreType(4);
						sportGameOdds.setDrawScore(particObj.getString("MoneyLine"));
						list.add(sportGameOdds);
						continue;
					}
					sportGameOdds.setScoreType(1);
					if("Team1".equals(particObj.getString("Type"))){
						teamName1 = particObj.getString("Name");
						sportGameOdds.setTeam(teamName1);
					}else{
						teamName2 = particObj.getString("Name");
						sportGameOdds.setTeam(teamName2);
					}
					handicapObj = particObj.getJSONObject("Handicap");
					sportGameOdds.setTeamNa(handicapObj.getString("Min"));
					sportGameOdds.setTeamScore(nf.format((-100.0)/handicapObj.getInteger("Price")+1));
					list.add(sportGameOdds);
					
				}
				
				//总分信息
				JSONObject totalsObj = eventJsonObj.getJSONObject("Totals");
				sportGameOdds = new SportGameOdds();
				sportGameOdds.setCid(leagueId);
				sportGameOdds.setEid(eventId);
				sportGameOdds.setScoreType(2);
				sportGameOdds.setScore(totalsObj.getString("Min"));
				sportGameOdds.setHigher(nf.format((-100.0)/totalsObj.getInteger("OverPrice")+1));
				sportGameOdds.setLower(nf.format((-100.0)/totalsObj.getInteger("UnderPrice")+1));
				list.add(sportGameOdds);
				
				
				//moduleGameList
				sportModuleGame.setCid(leagueId);
				sportModuleGame.setEid(eventId);
				sportModuleGame.setGameTime(eventJsonObj.getString("DateAndTime"));
				sportModuleGame.setTeamName1(teamName1);
				sportModuleGame.setTeamName2(teamName2);
				moduleGameList.add(sportModuleGame);
			}
		}
		return list;
	}
	
	public List<SportModuleGame> getModuleGameList() {
		return moduleGameList;
	}
	
}
