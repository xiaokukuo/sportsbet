package com.sport.bet.datasource.parsing.bet188;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.sport.bet.bean.model.SportGameOdds;
import com.sport.bet.datasource.parsing.AbstractPaser;
import com.sport.bet.datasource.parsing.bet365.PageGroupTeamPaser;

public class PageGroupTeamBet188Paser extends AbstractPaser<SportGameOdds> {

	Logger logger = LoggerFactory.getLogger(PageGroupTeamPaser.class);

	private volatile int gameId;
	
	@Override
	public List<SportGameOdds> parsed(String pageJson) {
		SportGameOdds sportGameOdds = new SportGameOdds();
		JSONArray moddcArray =  JSONObject.parseArray(pageJson);
		for (Object moddcObj : moddcArray) {
			JSONObject moddcJsonObj = (JSONObject) moddcObj;
			
			
			String groupName = moddcJsonObj.getString("n");
			String groupk = moddcJsonObj.getString("k");
			System.out.println(groupName+"---" + groupk);
			
			JSONObject eobj = (JSONObject) moddcJsonObj.getJSONArray("e").get(0);
			
			JSONObject gameOdds = eobj.getJSONObject("o");
			
			String teamPk = eobj.getString("pk");
			System.out.println(teamPk);
			
			
			sportGameOdds.setPkid(teamPk);
			sportGameOdds
			
			/*JSONObject eobj =  (JSONObject) eArray.get(0);
			JSONObject o = eobj.getJSONObject("o");
			System.out.println(o.toJSONString());*/
		}
		return null;
	}

}
