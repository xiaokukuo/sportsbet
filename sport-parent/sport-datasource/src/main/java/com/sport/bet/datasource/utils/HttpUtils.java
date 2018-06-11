package com.sport.bet.datasource.utils;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class HttpUtils {

	private static String URL365 = "https://www.365sport365.com/SportsBook.API/web?lid=10&zid=0&cid=42&ctid=42&pd=";
	
	public static String getUrl356(String pd){
		try {
			return URL365+URLEncoder.encode(pd, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static void main(String[] args) {
		String pd = "#AC#B18#C20448857#D19#E5760231#F19#G180114#H4#M74340490#O3#S^1#";
		
		System.out.println(getUrl356(pd));
	}
	
}
