package com.sport.bet.datasource.parsing;

import java.util.ArrayList;
import java.util.List;

import org.springframework.util.StringUtils;

public abstract class AbstractPaser<T> {
	
	protected static String SEPARATOR_CL = "\\|CL;";

	protected static String SEPARATOR_EV = "\\|EV;";

	protected static String SEPARATOR_MA = "\\|MA;";

	protected static String SEPARATOR_PA = "\\|PA;";

	protected static String EV = "|EV;";
	
	protected List<T> list = new ArrayList<T>();
	
	public abstract List<T> parsed(String page);
	
	protected String getLineValue(String[] elements, String name){
		for (String elem : elements) {
			if(elem.startsWith(name)){
				return elem.substring(3);
			}
		}
		return null;
	}
	
	protected String getLineValue(String resource, String name){
		if(StringUtils.isEmpty(resource)){
			return null;
		}
		
		String[] elements = resource.split(";");
		for (String elem : elements) {
			if(elem.startsWith(name)){
				return elem.substring(3);
			}
		}
		return null;
	}
	

}
