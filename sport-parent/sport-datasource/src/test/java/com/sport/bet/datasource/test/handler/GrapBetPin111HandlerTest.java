package com.sport.bet.datasource.test.handler;

import java.io.UnsupportedEncodingException;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.sport.bet.datasource.handler.GrapBetPin111Handler;
import com.sport.bet.datasource.test.base.BaseTest;

public class GrapBetPin111HandlerTest extends BaseTest {

	@Autowired
	private GrapBetPin111Handler grapBetPin111Handler;
	
	@Test
	public void paserTest() throws UnsupportedEncodingException{
		grapBetPin111Handler.grabData(1,"https://www.pin1111.com");
	}
	
}
