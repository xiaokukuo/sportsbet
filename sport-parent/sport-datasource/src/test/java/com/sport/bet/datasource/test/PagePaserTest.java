package com.sport.bet.datasource.test;

import java.io.UnsupportedEncodingException;
import java.util.List;

import org.htmlcleaner.HtmlCleaner;
import org.htmlcleaner.TagNode;
import org.htmlcleaner.XPatherException;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.sport.bet.bean.model.SportGameOdds;
import com.sport.bet.bean.model.SportModule;
import com.sport.bet.common.utils.HttpTool;
import com.sport.bet.datasource.handler.GrapBet365Handler;
import com.sport.bet.datasource.parsing.bet365.PagePaser;
import com.sport.bet.datasource.parsing.betu1688.PageU1688Paser;
import com.sport.bet.datasource.parsing.pin1111.PagePin1111Paser;
import com.sport.bet.datasource.test.base.BaseTest;

public class PagePaserTest extends BaseTest{
	
	@Autowired
	private GrapBet365Handler grapBet365Handler;
	
	@Autowired
	private PageU1688Paser pageU1688Paser;
	
	@Autowired
	private PagePin1111Paser pagePin1111Paser;
	
	@Test
	public void paserTest(){
		PagePaser pagePaser = new PagePaser();
		pagePaser.setResourceId(1);
		String url = "https://www.365sport365.com/SportsBook.API/web?lid=10&zid=0&pd=%23AS%23B18%23&cid=42&ctid=42";
		String pageStr = HttpTool.getSport365(url);
		List<SportModule> sportModuleList = pagePaser.parsed(pageStr);
		
		for (SportModule sportModule : sportModuleList) {
			System.out.println(sportModule.toString());
		}
	}

	@Test
	public void test() throws UnsupportedEncodingException{
		grapBet365Handler.grabData(1,"");
	}
	
	@Test
	public void testUrlpin111() throws UnsupportedEncodingException, XPatherException{
		String pageJosn = HttpTool.getSportPin111("https://www.pin1111.com/zh-cn/rtn");
		
		pagePin1111Paser.setResourceId(1);
		List<SportModule> a = pagePin1111Paser.parsed(pageJosn);
		for (SportModule sportModule : a) {
			System.out.println(sportModule.toString());
		}
		
	}
	
	@Test
	public void testUrl1688() throws XPatherException, InterruptedException {
		String pageJosnU188 = HttpTool.getSportU16888("http://www.u16888.com/zh-cn/euro/篮球");
		
		List<SportGameOdds> gameOddslist = pageU1688Paser.parsed(pageJosnU188);
		for (SportGameOdds sportGameOdds : gameOddslist) {
			System.out.println(sportGameOdds.toString());
		}
		
	}
	
	@Test
	public void testUrlpin111Game() throws UnsupportedEncodingException, XPatherException{
		String pageJosn = HttpTool.getSportPin111("https://www.pin1111.com/zh-cn/odds/match/basketball/argentina/argentina-liga-nacional");
		
		HtmlCleaner hc = new HtmlCleaner();
		TagNode tn = hc.clean(pageJosn);
		
		String xpath = "//div[@ng-controller='GuestLinesController']";
		
		TagNode divtn = (TagNode) tn.evaluateXPath(xpath)[0];
		
		String ngInit = divtn.getAttributeByName("ng-init").substring(5);
		
		String[] arr = ngInit.split(",");
		String urlPre = "https://www.pin1111.com/webapi/1.17/api/v1/GuestLines/Deadball/";
		String urlEnd = "?callback=angular.callbacks._0"; 
		
		String newurl =  urlPre + arr[0].trim() + "/" + arr[1].trim() + urlEnd;
		
		String gameJson = HttpTool.getSportPin111(newurl);
		gameJson = gameJson.substring(gameJson.indexOf("{"), gameJson.indexOf(");"));
		
		JSONObject jsonObj = (JSONObject) JSONObject.parse(gameJson);
		
		System.out.println(jsonObj.getString("OddsType"));
		
		JSONArray leaguesArray = jsonObj.getJSONArray("Leagues");
		
		JSONObject leagueJsonObj = null;
		JSONArray  eventsArray = null;
		JSONObject eventJsonObj = null;
		for (Object leagueObj : leaguesArray) {
			leagueJsonObj= (JSONObject) leagueObj; 
			eventsArray = leagueJsonObj.getJSONArray("Events");
			for (Object eveObj : eventsArray) {
				eventJsonObj = (JSONObject) eveObj;
				
				eventJsonObj.getString("EventId");
				eventJsonObj.getString("LeagueId");
				eventJsonObj.getString("DateAndTime");
				
				//总分信息
				JSONObject totalsObj = eventJsonObj.getJSONObject("Totals");
				
				
				System.err.println(totalsObj.getInteger("OverPrice"));
				totalsObj.getInteger("UnderPrice");
				totalsObj.getString("Min");
				
				//让分信息
				JSONArray  participants = eventJsonObj.getJSONArray("Participants");
				for (Object participant : participants) {
					
					JSONObject particObj = (JSONObject) participant;
					particObj.getString("Id");
					particObj.getString("Name");
					particObj.getInteger("MoneyLine");
					
					JSONObject handicapObj = particObj.getJSONObject("Handicap");
					handicapObj.getInteger("Price");
					handicapObj.getString("Min");
				}
			}
		}
	}
}
