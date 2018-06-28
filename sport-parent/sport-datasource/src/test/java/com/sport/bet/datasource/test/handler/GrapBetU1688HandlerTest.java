package com.sport.bet.datasource.test.handler;

import java.io.UnsupportedEncodingException;
import java.time.LocalDate;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.sport.bet.datasource.handler.GrapBetU1688Handler;
import com.sport.bet.datasource.test.base.BaseTest;

public class GrapBetU1688HandlerTest extends BaseTest {

	@Autowired
	private GrapBetU1688Handler grapBetU1688Handler;
	
	@Test
	public void paserTest() throws UnsupportedEncodingException{
		grapBetU1688Handler.grabData(1, "http://www.u16888.com/euro/basketball/"+LocalDate.now());
	}
	
}
