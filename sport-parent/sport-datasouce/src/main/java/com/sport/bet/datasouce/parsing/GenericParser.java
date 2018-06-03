package com.sport.bet.datasouce.parsing;

import java.util.List;

import com.sport.bet.bean.dto.SportMenuDTO;
import com.sport.bet.bean.model.SportModule;
import com.sport.bet.bean.model.SportModuleGame;

public abstract class GenericParser {
	
	public static String  MENU_SEPARATOR = "\\|CL;";
	
	public static String  SUB_SEPARATOR= "\\|EV;";
	
	abstract List<SportMenuDTO> parseMenu(String url);
	
	abstract List<SportModule> parseSportModule(String url, int resourceId);
	
	abstract List<SportModuleGame> parseSportModuleGame(String url, int moduleId,String name);
	
}
