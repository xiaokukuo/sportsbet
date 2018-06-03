package com.sport.bet.datasouce.parsing;

import java.util.List;

import com.sport.bet.bean.dto.SportMenuDTO;
import com.sport.bet.bean.model.SportModule;

public abstract class GenericParser {
	
	public static String  MENU_SEPARATOR = "\\|CL;";
	
	public static String  SUB_SEPARATOR= "\\|EV;";
	
	abstract List<SportMenuDTO> parseMenu(String url);
	
	abstract List<SportModule> parseSportModule(String sportId, int resourceId);
	
}
