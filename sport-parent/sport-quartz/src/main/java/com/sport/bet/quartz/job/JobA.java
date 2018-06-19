package com.sport.bet.quartz.job;

import java.util.Date;

import org.quartz.DisallowConcurrentExecution;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.JobKey;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@DisallowConcurrentExecution
public class JobA implements Job {
	
	private static Logger _log = LoggerFactory.getLogger(JobA.class);

	public void execute(JobExecutionContext context) throws JobExecutionException {
		//applicationContext = ApplicationContextProvider.getApplicationContext();
		JobKey jobKey = context.getJobDetail().getKey();
		_log.info("JobA says: " + jobKey + " executing at " + new Date());
		
		System.err.println("JobA  ");
	}
}
