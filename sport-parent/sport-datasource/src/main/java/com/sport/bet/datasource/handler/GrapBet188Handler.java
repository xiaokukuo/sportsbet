package com.sport.bet.datasource.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.sport.bet.common.utils.HttpTool;
import com.sport.bet.datasource.parsing.bet188.PageBet188Paser;
import com.sport.bet.datasource.parsing.bet188.PageGroupBet188Paser;

@Component
public class GrapBet188Handler {
	
	@Autowired
	private PageBet188Paser pageBet188Paser;
	
	@Autowired
	private PageGroupBet188Paser pageGroupBet188Paser;

	String url = "https://landing-sb.prdasbb18a1.com/zh-cn/Service/CentralService?GetData&ts=1528967723534";
	public void grabGroup(){
		
		String pageJosn = HttpTool.getSport188(url);
		
		JSONObject jsonObject = JSONObject.parseObject(pageJosn);
		JSONObject lpd = jsonObject.getJSONObject("lpd");
		JSONObject mod = jsonObject.getJSONObject("mod");
		
		JSONArray moddcArray = mod.getJSONObject("d").getJSONArray("c");
		
		
		
		for (Object moddcObj : moddcArray) {
			JSONObject moddcJsonObj = (JSONObject) moddcObj;
			
			
			String n = moddcJsonObj.getString("n");
			String k = moddcJsonObj.getString("k");
			System.out.println(n+"---"+k);
			
			JSONObject eobj = (JSONObject) moddcJsonObj.getJSONArray("e").get(0);
			JSONObject o = eobj.getJSONObject("o");
			
			String teamPk = eobj.getString("pk");
			System.out.println(teamPk);
			
			/*JSONObject eobj =  (JSONObject) eArray.get(0);
			JSONObject o = eobj.getJSONObject("o");
			System.out.println(o.toJSONString());*/
		}
		
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
		
		
	}
	
}
