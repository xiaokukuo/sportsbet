package com.sport.bet.datasouce.parsing.sport365;

import java.util.ArrayList;
import java.util.List;

import com.sport.bet.bean.model.SportModule;
import com.sport.bet.common.utils.HttpTool;

public class ParserGroup {
	
	private static String  SEPARATOR_CL = "\\|CL;";
	
	private static String  SEPARATOR_EV = "\\|EV;";
	
	private static String  SEPARATOR_MA = "\\|MA;";
	
	private static String  SEPARATOR_PA = "\\|PA;";
	
	private static String  EV= "|EV;";


	public List<SportModule> parseSportModule(String url, int resourceId) {
		List<SportModule> sportModuleList = new ArrayList<SportModule>();
		SportModule sportModule = null;
		
		String response = HttpTool.getSport365(url);
		
		if(!response.startsWith("F|CL;") || !response.endsWith("|")){
			System.err.println("返回报文错误");
		}
		
		String [] sportGroupLines = response.split(SEPARATOR_EV);
		
		for (String sportGroupLine : sportGroupLines) {
			if(!sportGroupLine.contains("比赛投注")){
				continue;
			}
			sportModule = new SportModule();
			sportModule.setResourceId(resourceId);
			String groupName = sportGroupLine.substring(0,sportGroupLine.indexOf(";DO"));
			sportModule.setGroupName(groupName.split(";")[1].substring(3));
			
			this.parseGroupLine(sportGroupLine, sportModule);
			
			sportModuleList.add(sportModule);
		}
		
		return sportModuleList;
	}
	
	private void parseGroupLine(String line,SportModule sportModule){
		String [] elements = line.split(SEPARATOR_MA);
		int lenght = 0;
		for (String ele : elements) {
			if(ele.contains("投注盘")){
				String [] items = ele.split(SEPARATOR_PA);
				for (String item : items) {
					lenght = item.length()-5;
					if(item.contains("比赛投注")){
						sportModule.setGameLinesPd(item.substring(item.indexOf("PD")+3, lenght));
					}
					if(item.contains("上半场")){
						sportModule.setFirstHalfPd(item.substring(item.indexOf("PD")+3, lenght));
					}
					if(item.contains("下半场")){
						sportModule.setSecondHalfPd(item.substring(item.indexOf("PD")+3, lenght));
					}
					if(item.contains("第1赛节")){
						sportModule.setFirstQuarterPd(item.substring(item.indexOf("PD")+3, lenght));
					}
					if(item.contains("第2赛节")){
						sportModule.setSecondQuarterPd(item.substring(item.indexOf("PD")+3, lenght));
					}
					if(item.contains("第3赛节")){
						sportModule.setThirdQuarterPd(item.substring(item.indexOf("PD")+3, lenght));
					}
					if(item.contains("第4赛节")){
						sportModule.setFourthQuarterPd(item.substring(item.indexOf("PD")+3, lenght));
					}
				}
				break;
			}
			
		}
	}
	
}
