package com.sport.bet.datasource.utils;

public class StringUtils {
	
	public static String substring(String content, String beginStr, String endStr){
		return content.substring(content.indexOf(beginStr) + beginStr.length(), content.indexOf(endStr));
	}
	
}
