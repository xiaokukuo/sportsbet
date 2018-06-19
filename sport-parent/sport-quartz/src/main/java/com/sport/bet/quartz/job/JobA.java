package com.sport.bet.quartz.job;

import java.util.Date;
import java.util.logging.Logger;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.quartz.DisallowConcurrentExecution;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.JobKey;

@DisallowConcurrentExecution
public class JobA implements Job {
	
	Logger logger = LoggerFactory.getLogger(JobA.class);

	public void execute(JobExecutionContext context) throws JobExecutionException {
		//applicationContext = ApplicationContextProvider.getApplicationContext();
		JobKey jobKey = context.getJobDetail().getKey();
		logger.info("JobA says: " + jobKey + " executing at " + new Date());
		
		
	}
}
