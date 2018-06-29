package com.sport.bet.datasource.parsing.bet188;

import java.util.List;

import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.sport.bet.bean.model.SportModule;

@Component
public class PageBet188Paser extends Abstract188Paser<SportModule> {
	
	private volatile JSONArray next;
	
	@Override
	public List<SportModule> parsed(String pageJosn) {
		JSONArray psmdArray = JSONArray.parseArray(pageJosn);
		
		for (Object psmdObj : psmdArray) {
			JSONObject psmdJsonObj = (JSONObject) psmdObj;
			
			if("basketball".equals(psmdJsonObj.getString("sen"))){
				JSONArray pucArray = psmdJsonObj.getJSONArray("puc");
				SportModule module = null;
				for (Object pubObj : pucArray) {
					JSONObject pubJsonObj = (JSONObject) pubObj;
					module = new SportModule();
					module.setResourceId(resourceId);
					module.setGroupName( pubJsonObj.getString("cn")); // 模块名称
					module.setCid(pubJsonObj.getString("cid")); // 模块ID
					list.add(module);
				}
				
				this.setNext(pucArray);
				break;
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

	public JSONArray getNext() {
		return next;
	}

	public void setNext(JSONArray next) {
		this.next = next;
	}
	
}
