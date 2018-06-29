package com.sport.bet.quartz.job;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sport.bet.datasource.handler.GrapBet188Handler;
import com.sport.bet.quartz.common.ApplicationContextProvider;

public class GrapBet188Job implements Job {
	
	private static Logger logger = LoggerFactory.getLogger(GrapBet188Job.class);

	private GrapBet188Handler grapBet188Handler;
	
	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
		String url = "https://landing-sb.prdasbb18a1.com/en-gb/Service/CentralService?GetData&ts=1530172534977";
		
		logger.info("GrapBet188Job");
		grapBet188Handler = ApplicationContextProvider.getApplicationContext().getBean(GrapBet188Handler.class);
		
		grapBet188Handler.grabData(1, url);
	}

}
