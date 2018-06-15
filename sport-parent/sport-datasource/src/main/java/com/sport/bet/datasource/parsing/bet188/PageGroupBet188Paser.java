package com.sport.bet.datasource.parsing.bet188;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.sport.bet.bean.model.SportModuleGame;
import com.sport.bet.datasource.parsing.AbstractPaser;
import com.sport.bet.datasource.parsing.bet365.PageGroupPaser;

@Component
public class PageGroupBet188Paser extends AbstractPaser<SportModuleGame> {

Logger logger = LoggerFactory.getLogger(PageGroupPaser.class);
	
	private volatile int resourceId;
	
	private volatile int moduleId;
	
	@Override
	public List<SportModuleGame> parsed(String pageJson) {
		SportModuleGame moduleGame = null;
		JSONArray pucArray =  JSONObject.parseArray(pageJson);
		
		for (Object pubObj : pucArray) {
			JSONObject pubJsonObj = (JSONObject) pubObj;
			String groupCid = pubJsonObj.getString("cid");
			
			JSONArray cesArray = pubJsonObj.getJSONArray("ces");
			
			for (Object cesObj : cesArray) {
				JSONObject cesJsonObj = (JSONObject) cesObj;
				if(cesJsonObj.getBoolean("ior")){
					continue;
				}
				moduleGame = new SportModuleGame();
				moduleGame.setResourceId(resourceId);
				moduleGame.setSportGroupId(Integer.parseInt(groupCid));
				moduleGame.setTeamName1(cesJsonObj.getString("ht"));
				moduleGame.setTeamName2(cesJsonObj.getString("at"));
				moduleGame.setEid(cesJsonObj.getString("eid"));
				
				moduleGame.setGameTime(cesJsonObj.getString("esd")+","+cesJsonObj.getString("est"));
				
				list.add(moduleGame);
				
			}
		}
		
		return list;
	}

	public int getResourceId() {
		return resourceId;
	}

	public void setResourceId(int resourceId) {
		this.resourceId = resourceId;
	}

	public int getModuleId() {
		return moduleId;
	}

	public void setModuleId(int moduleId) {
		this.moduleId = moduleId;
	}
	
}
