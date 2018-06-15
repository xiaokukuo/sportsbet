package com.sport.bet.datasource.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.sport.bet.common.utils.HttpTool;
import com.sport.bet.datasource.parsing.bet188.PageBet188Paser;
import com.sport.bet.datasource.parsing.bet188.PageGroupBet188Paser;
import com.sport.bet.datasource.parsing.bet188.PageGroupTeamBet188Paser;

@Component
public class GrapBet188Handler {
	
	@Autowired
	private PageBet188Paser pageBet188Paser;
	
	@Autowired
	private PageGroupBet188Paser pageGroupBet188Paser;
	
	@Autowired
	private PageGroupTeamBet188Paser pageGroupTeamBet188Paser;

	String url = "https://landing-sb.prdasbb18a1.com/zh-cn/Service/CentralService?GetData&ts=1528967723534";
	public void grabGroup(){
		
		String pageJosn = HttpTool.getSport188(url);
		
		JSONObject jsonObject = JSONObject.parseObject(pageJosn);
		JSONObject lpd = jsonObject.getJSONObject("lpd");
		JSONObject mod = jsonObject.getJSONObject("mod");
		
		/*JSONArray psmdArray = lpd.getJSONObject("psm").getJSONArray("psmd");
		pageBet188Paser.setResourceId(1);
		List<SportModule> moduleList = pageBet188Paser.parsed(psmdArray.toJSONString());
		
		for (SportModule sportModule : moduleList) {
			System.err.println(sportModule.toString());
			
			System.err.println("-------------------------");
		}
		
		pageGroupBet188Paser.setResourceId(1);
		
		List<SportModuleGame>  sportModuleGameList = pageGroupBet188Paser.parsed(pageBet188Paser.getNext().toJSONString());
		
		for (SportModuleGame sportModuleGame : sportModuleGameList) {
			System.err.println(sportModuleGame.toString());
		}*/
		
		
		JSONArray moddcArray = mod.getJSONObject("d").getJSONArray("c");
		
		pageGroupTeamBet188Paser.parsed(moddcArray.toJSONString());
		
	}
	
}
