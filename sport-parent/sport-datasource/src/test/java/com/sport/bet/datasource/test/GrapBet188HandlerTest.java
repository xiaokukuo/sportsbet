package com.sport.bet.datasource.test;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.sport.bet.datasource.handler.GrapBet188Handler;
import com.sport.bet.datasource.test.base.BaseTest;

public class GrapBet188HandlerTest  extends BaseTest {
	
	@Autowired
	private GrapBet188Handler GrapBet188Handler;
	
	@Test
	public void paserTest(){
		GrapBet188Handler.grabGroup();
	}

}
