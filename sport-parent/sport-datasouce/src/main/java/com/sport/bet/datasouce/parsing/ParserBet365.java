package com.sport.bet.datasouce.parsing;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.sport.bet.bean.model.Sport;
import com.sport.bet.bean.model.SportModule;
import com.sport.bet.common.utils.HttpTool;

@Component
public class ParserBet365 extends GenericParser {

	public static String  menu_separator = "\\|CL;";
	
	public static String  sub_separator= "\\|EV;";
	
	@Override
	public List<Sport> parseMenu(String url, int resourceId) {
		List<Sport> sportList = new ArrayList<>();
		String response = HttpTool.getSport365(url);
		
		if(!response.startsWith("F|CL;") || !response.endsWith("|")){
			System.err.println("返回报文错误");
		}
		
		response = response.substring(5,response.length());
		String [] strArr = response.split(menu_separator);
		
		Sport sport = null;
		for (int i = 0; i < strArr.length; i++) {
			String temp = strArr[i];
			if(temp.contains(sub_separator)){
				continue;
			}
			
			String[] subArr = temp.split("\\;");
			
			String key = null;
			String value = null;
			
			for (int j = 0; j < subArr.length; j++) {
				String subTemp = subArr[j].trim();
				
				if(subTemp.startsWith("ID") && subTemp.substring(3).startsWith("-")){
					break;
				}
				
				if(subTemp.startsWith("NA")){
					key = subTemp.substring(3);
				}
				if(subTemp.startsWith("PD")){
					value = subTemp;
				}
			}
			if(key != null && value != null){
				sport = new Sport();
				sport.setName(key);
				sport.setPd(value);
				sportList.add(sport);
			}
			
		}
		
		return sportList;
	}

	@Override
	public List<SportModule> parseSportModule(String url, int resourceId) {
		List<SportModule> sprotGameList = new ArrayList<SportModule>();
		String response = HttpTool.getSport365(url);
		if(!response.startsWith("F|CL;") || !response.endsWith("|")){
			System.err.println("返回报文错误");
		}
		//System.err.println(response);
		
		String [] strArr = response.split(sub_separator);
		
		SportModule sportGame = null;
		for (int i = 0; i < strArr.length; i++) {
			String temp = strArr[i];
			
			if(temp.contains("比赛投注")){
				sportGame = new SportModule();
				sportGame.setResourceId(resourceId);
				
				String groupName = temp.substring(temp.indexOf("NA=")+3,temp.indexOf(";DO"));
				sportGame.setGroupName(groupName);
				
				String gameLines = temp.substring(temp.indexOf("比赛投注"));
				String gameLinesPd = gameLines.substring(gameLines.indexOf("PD"), gameLines.indexOf(";FF="));
				sportGame.setGameLinesPd(gameLinesPd);
				
				sprotGameList.add(sportGame);
			}
			
		}
		
		return sprotGameList;
	}
	
}
