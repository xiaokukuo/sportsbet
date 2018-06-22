package com.sport.bet.quartz.job;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GrabBet365Job implements Job {
	
	private static Logger logger = LoggerFactory.getLogger(GrabBet365Job.class);

	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
		logger.info("GrabBet365Job");
	}

}
