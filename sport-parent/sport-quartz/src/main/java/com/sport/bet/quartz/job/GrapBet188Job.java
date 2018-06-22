package com.sport.bet.quartz.job;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GrapBet188Job implements Job {
	
	private static Logger logger = LoggerFactory.getLogger(GrapBet188Job.class);

	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
		
		logger.info("GrapBet188Job");
		
	}

}
