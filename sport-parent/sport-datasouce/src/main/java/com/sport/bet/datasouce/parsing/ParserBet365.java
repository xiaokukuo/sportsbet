package com.sport.bet.datasouce.parsing;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.sport.bet.bean.dto.SportMenuDTO;
import com.sport.bet.bean.model.SportModule;
import com.sport.bet.common.utils.HttpTool;

@Component
public class ParserBet365 extends GenericParser{

	private static String  SEPARATOR_CL = "\\|CL;";
	
	private static String  SEPARATOR_EV= "\\|EV;";
	
	private static String  EV= "|EV;";
	
	private static String  SEPARATOR_MA= "\\|MA;";
	
	@Override
	public List<SportMenuDTO> parseMenu(String url) {
		
		List<SportMenuDTO> sportMenuList = new ArrayList<SportMenuDTO>();
		SportMenuDTO sprotMenu= null;
		
		String response = HttpTool.getSport365(url);
		if(!response.startsWith("F|CL;") || !response.endsWith("|")){
			System.err.println("返回报文错误");
		}
		
		String [] menuLines = response.split(SEPARATOR_CL);
		
		for (String menuLine : menuLines) {
			if(menuLine.contains(EV) || menuLine.startsWith("F") || menuLine.substring(3).startsWith("-")){
				continue;
			}
			
			String menuLineTemp = menuLine.substring(menuLine.indexOf("NA"));
			String[] elements = menuLineTemp.split("\\;");

			sprotMenu = new SportMenuDTO();
			sprotMenu.setSportName(elements[0].substring(3));
			sprotMenu.setSportPd(elements[1].substring(3));
			
			sportMenuList.add(sprotMenu);
		}
		
		return sportMenuList;
	}

	@Override
	public List<SportModule> parseSportModule(String url, int resourceId) {
		List<SportModule> sprotGameList = new ArrayList<SportModule>();
		String response = HttpTool.getSport365(url);
		if(!response.startsWith("F|CL;") || !response.endsWith("|")){
			System.err.println("返回报文错误");
		}
		
		String [] strArr = response.split(SEPARATOR_EV);
		
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
