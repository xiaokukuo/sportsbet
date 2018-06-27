package com.sport.bet.datasource.test.handler;

import java.io.UnsupportedEncodingException;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.sport.bet.datasource.handler.GrapBet365Handler;
import com.sport.bet.datasource.test.base.BaseTest;

public class GrapBet365HandlerTest extends BaseTest {
	
	@Autowired
	private GrapBet365Handler grapBet365Handler;
	
	@Test
	public void paserTest() throws UnsupportedEncodingException{
		                              
		grapBet365Handler.grabData(1, "https://www.365sport365.com/SportsBook.API/web?lid=10&zid=0&pd=%23AS%23B18%23&cid=42&ctid=42");
	}
}
