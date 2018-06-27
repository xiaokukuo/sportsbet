package com.sport.bet.datasource.utils;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class HttpUtils {

	private static String URL365_ZH = "https://www.365sport365.com/SportsBook.API/web?lid=10&zid=0&cid=42&ctid=42&pd=";
	
	private static String URL365_EN = "https://www.365sport365.com/SportsBook.API/web?lid=1&zid=3&cid=42&ctid=42&pd=";
	
	
	public static String getUrl356(String language ,String pd){
		try {
			if("en".equals(language)){
				return URL365_EN+URLEncoder.encode(pd, "UTF-8");
			}else{
				return URL365_ZH+URLEncoder.encode(pd, "UTF-8");
			}
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return null;
	}
	
}
