package com.sport.bet.quartz.job;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GrabBetU1688Job implements Job {

	private static Logger logger = LoggerFactory.getLogger(GrabBetU1688Job.class);
	
	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
		
		logger.info("GrabBetU1688Job");
		
	}

}
