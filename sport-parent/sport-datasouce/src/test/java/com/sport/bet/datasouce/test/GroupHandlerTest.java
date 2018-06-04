package com.sport.bet.datasouce.test;

import java.io.UnsupportedEncodingException;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.sport.bet.datasouce.handler.GrapHandler;
import com.sport.bet.datasouce.test.base.BaseTest;

public class GroupHandlerTest  extends BaseTest {

	@Autowired
	private GrapHandler grapHandler;
	
	@Test
	public void grapHandler() throws UnsupportedEncodingException{
		grapHandler.grabGroupModule();
	}
	
	
	
	@Test
	public void grapHandlerTeamSgao() throws UnsupportedEncodingException{
		String Pd = "#AC#B18#C20559281#D19#E5757607#F19#P^48#Q^1#W^36";
		
		grapHandler.grabScore(Pd);
		
	}
	
}
