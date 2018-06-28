package com.sport.bet.datasource.parsing.bet188;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.sport.bet.bean.model.SportGameOdds;
import com.sport.bet.datasource.parsing.AbstractPaser;
import com.sport.bet.datasource.parsing.bet365.PageGroupTeamPaser;

@Component
public class PageGroupTeamBet188Paser extends AbstractPaser<SportGameOdds> {

	Logger logger = LoggerFactory.getLogger(PageGroupTeamPaser.class);

	@Override
	public List<SportGameOdds> parsed(String pageJson) {
		SportGameOdds sportGameOdds = null;
		String teamNa = null;
		// 篮球的板块集合
		JSONArray moddcArray = JSONObject.parseArray(pageJson);
		for (Object modcObj : moddcArray) {
			JSONObject modcJsonObj = (JSONObject) modcObj;

			//String groupName = modcJsonObj.getString("n"); // 模块名称
			String cid = modcJsonObj.getString("k"); // d-c -k 篮球板块ID
 
			//板块下的队伍集合
			JSONArray modeArray = modcJsonObj.getJSONArray("e");
			for (Object modeObj : modeArray) {
				JSONObject modeJsonObj = (JSONObject) modeObj;
				if(!modeJsonObj.getBoolean("hasParlay")){
					 continue;
				} 
				
				String eid = modeJsonObj.getString("k"); // 篮球板块下队伍ID
				JSONObject gameOdds = modeJsonObj.getJSONObject("o"); // 比分集合类
				
				JSONArray ahArray = gameOdds.getJSONArray("ah"); // 让分
				
				if(ahArray !=null && ahArray.size()>0){
					for (int i = 0; i < ahArray.size(); i=i+8) {
						sportGameOdds = new SportGameOdds();
						sportGameOdds.setCid(cid); // 篮球的那个板块id
						sportGameOdds.setEid(eid); // 篮球板块中队伍Id
						
						sportGameOdds.setScoreType(1);
						
						teamNa = ahArray.getString(i+1);
						if(teamNa.startsWith("+")){
							sportGameOdds.setTeamNa(teamNa.substring(1)); //让分系数
						}else{
							sportGameOdds.setTeamNa(teamNa); //让分系数
						}
						sportGameOdds.setTeamScore(ahArray.getString(i+5));
						list.add(sportGameOdds);
						
						
						sportGameOdds = new SportGameOdds();
						sportGameOdds.setCid(cid); // 篮球的那个板块id
						sportGameOdds.setEid(eid); // 篮球板块中队伍Id
						sportGameOdds.setScoreType(1);
						
						teamNa = ahArray.getString(i+3);
						if(teamNa.startsWith("+")){
							sportGameOdds.setTeamNa(teamNa.substring(1)); //让分系数
						}else{
							sportGameOdds.setTeamNa(teamNa); //让分系数
						}
					
						sportGameOdds.setTeamScore(ahArray.getString(i+7));
						list.add(sportGameOdds);
						teamNa = null;
					}
				}
				
				JSONArray ouArray = gameOdds.getJSONArray("ou"); // 总分
				
				if(ouArray !=null && ouArray.size()>0){
					//1:让分，2：总分，3：强弱盘
					for (int i = 0; i < ouArray.size(); i=i+8) {
						sportGameOdds = new SportGameOdds();
						sportGameOdds.setCid(cid); // 篮球的那个板块id
						sportGameOdds.setEid(eid); // 篮球板块中队伍Id

						
						sportGameOdds.setScoreType(2);
						sportGameOdds.setScore(ouArray.getString(i+1));
						sportGameOdds.setHigher(ouArray.getString(i+5));
						sportGameOdds.setLower(ouArray.getString(i+7));
						list.add(sportGameOdds);
						
					}
				}
				
			}
			//JSONArray mlArray = gameOdds.getJSONArray("ml"); // 独赢盘
			//JSONArray oeArray = gameOdds.getJSONArray("oe"); // 总分:单 / 双
		}
		return list;
	}

}
