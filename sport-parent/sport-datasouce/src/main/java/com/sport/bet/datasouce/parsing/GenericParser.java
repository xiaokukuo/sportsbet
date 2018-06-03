package com.sport.bet.datasouce.parsing;

import java.util.List;

import com.sport.bet.bean.model.Sport;
import com.sport.bet.bean.model.SportModule;

public abstract class GenericParser {
	
	public static String  MENU_SEPARATOR = "\\|CL;";
	
	public static String  SUB_SEPARATOR= "\\|EV;";
	
	abstract List<Sport> parseMenu(String url, int resourceId);
	
	abstract List<SportModule> parseSportModule(String sportId, int resourceId);
	
}
