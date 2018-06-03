package com.sport.bet.datasouce.test;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sport.bet.datasouce.handler.GrapHandler;
import com.sport.bet.datasouce.parsing.ParserBet365;
import com.sport.bet.datasouce.test.base.BaseTest;

@Component
public class ParserBet365Test extends BaseTest {

	public static String  menu_separator = "\\|CL;";
	
	public static String  sub_separator= "\\|EV;";
	
	@Autowired
	private GrapHandler grapHandler;
	
	private static String URL = "https://www.365sport365.com/SportsBook.API/web?lid=10&zid=0&cid=42&ctid=42&pd=";
	
	
	@Autowired
	private ParserBet365 parserBet365;
	
	@Test
	public void parseGame() throws UnsupportedEncodingException {
		
		String pd = "#AS#B18#";
		String moduleUrl = URL+URLEncoder.encode(pd, "UTF-8");
		
		System.err.println(moduleUrl);
		parserBet365.parseSportModule(moduleUrl, 1);
		
	}

}
