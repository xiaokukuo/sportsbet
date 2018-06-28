package com.sport.bet.datasource.test.handler;

import java.io.UnsupportedEncodingException;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.sport.bet.datasource.handler.GrapBet188Handler;
import com.sport.bet.datasource.test.base.BaseTest;

public class GrapBet188HandlerTest extends BaseTest {

	@Autowired
	private GrapBet188Handler grapBet188Handler;
	
	@Test
	public void paserTest() throws UnsupportedEncodingException{
		String url = "https://landing-sb.prdasbb18a1.com/en-gb/Service/CentralService?GetData&ts=1530172534977";
		
		grapBet188Handler.grabData(1, url);
	}
	
}
