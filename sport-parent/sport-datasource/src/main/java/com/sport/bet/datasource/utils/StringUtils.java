package com.sport.bet.datasource.utils;

public class StringUtils {
	
	public static String substring(String content, String from, String to){
		return content.substring(content.indexOf(from) + from.length(), content.indexOf(to));
	}
	
	public static String substring(String content, String from){
		return content.substring(content.indexOf(from) + from.length());
	}
	
}
