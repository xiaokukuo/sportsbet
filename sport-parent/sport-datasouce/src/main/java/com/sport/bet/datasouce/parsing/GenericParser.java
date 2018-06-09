package com.sport.bet.datasouce.parsing;

import java.util.List;

import com.sport.bet.bean.dto.SportMenuDTO;
import com.sport.bet.bean.model.SportGameOdds;
import com.sport.bet.bean.model.SportModule;
import com.sport.bet.bean.model.SportModuleGame;

public abstract class GenericParser {
	
	public static String  MENU_SEPARATOR = "\\|CL;";
	
	public static String  SUB_SEPARATOR= "\\|EV;";
	
	abstract List<SportMenuDTO> parseMenu(String url);
	
	abstract List<SportModule> parseSportModule(String url, int resourceId);
	
	abstract List<SportModuleGame> parseSportModuleGame(String url,int resourceId, int moduleId);
	
	abstract List<SportGameOdds> parseSportGameScore(String url,int resourceId, int gameId);
	
	protected String getLineValue(String[] elements, String name){
		for (String elem : elements) {
			if(elem.startsWith(name)){
				return elem.substring(3);
			}
		}
		return null;
	}
	
	protected String getLineValue(String resource, String name){
		String[] elements = resource.split(";");
		for (String elem : elements) {
			if(elem.startsWith(name)){
				return elem.substring(3);
			}
		}
		return null;
	}
	
}
