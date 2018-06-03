package com.sport.bet.datasouce.task;

import org.springframework.beans.factory.annotation.Autowired;

import com.sport.bet.core.service.impl.SportServiceImpl;
import com.sport.bet.datasouce.handler.GrapHandler;


public class Bet365Task implements Runnable{

	@Autowired
	private GrapHandler grapHandler;
	
	@Autowired
	private SportServiceImpl sportService;
	
	@Override
	public void run() {
		
		String pd =sportService.findPdByResourceId(1, "365");
		grapHandler.grabGpropGame(pd,1);
	}


}
