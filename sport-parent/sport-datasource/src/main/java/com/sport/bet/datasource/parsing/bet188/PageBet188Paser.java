package com.sport.bet.datasource.parsing.bet188;

import java.util.List;

import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.sport.bet.bean.model.SportModule;
import com.sport.bet.datasource.parsing.AbstractPaser;

@Component
public class PageBet188Paser extends AbstractPaser<SportModule> {
	
	private volatile int resourceId;
	
	private volatile JSONArray next;
	
	@Override
	public List<SportModule> parsed(String pageJosn) {
		JSONArray psmdArray = JSONArray.parseArray(pageJosn);
		
		for (Object psmdObj : psmdArray) {
			JSONObject psmdJsonObj = (JSONObject) psmdObj;
			
			if("basketball".equals(psmdJsonObj.getString("sen"))){
				JSONArray pucArray = psmdJsonObj.getJSONArray("puc");
				
				for (Object pubObj : pucArray) {
					JSONObject pubJsonObj = (JSONObject) pubObj;
					String groupCid = pubJsonObj.getString("cid");
					String groupCn = pubJsonObj.getString("cn");
					
					SportModule module = new SportModule();
					module.setResourceId(resourceId);
					module.setGroupName(groupCn);
					module.setCid(groupCid);
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
