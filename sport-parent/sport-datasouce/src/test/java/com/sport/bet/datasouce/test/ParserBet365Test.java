package com.sport.bet.datasouce.test;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sport.bet.datasouce.handler.GrapHandler;
import com.sport.bet.datasouce.test.base.BaseTest;

@Component
public class ParserBet365Test extends BaseTest {

	public static String  menu_separator = "\\|CL;";
	
	public static String  sub_separator= "\\|EV;";
	
	@Autowired
	private GrapHandler grapHandler;
	
	@Test
	public void parseGame() {
		
		
		
	}

}
