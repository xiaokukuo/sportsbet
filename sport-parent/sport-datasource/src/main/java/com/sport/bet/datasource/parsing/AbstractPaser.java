package com.sport.bet.datasource.parsing;

import java.text.NumberFormat;
import java.util.List;

import org.springframework.util.StringUtils;

public abstract class AbstractPaser<T> {
	
	protected static NumberFormat nf = NumberFormat.getNumberInstance();
	
	protected static String SEPARATOR_CL = "\\|CL;";

	protected static String SEPARATOR_EV = "\\|EV;";

	protected static String SEPARATOR_MA = "\\|MA;";

	protected static String SEPARATOR_PA = "\\|PA;";

	protected static String EV = "|EV;";
	
	protected volatile int resourceId;
	
	public abstract List<T> parsed(String page);
	
	static{
		nf.setMaximumFractionDigits(2);
	}
	
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

	public int getResourceId() {
		return resourceId;
	}

	public void setResourceId(int resourceId) {
		this.resourceId = resourceId;
	}

	
}
