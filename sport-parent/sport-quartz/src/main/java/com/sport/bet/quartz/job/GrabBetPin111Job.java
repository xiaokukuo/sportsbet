package com.sport.bet.quartz.job;

import java.io.UnsupportedEncodingException;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sport.bet.datasource.handler.GrapBetPin111Handler;
import com.sport.bet.quartz.common.ApplicationContextProvider;

public class GrabBetPin111Job implements Job {

	private static Logger logger = LoggerFactory.getLogger(GrabBetPin111Job.class);
	private GrapBetPin111Handler grapBetPin111Handler;
	
	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
		logger.info("GrabBetPin111Job   start");
		
		grapBetPin111Handler = ApplicationContextProvider.getApplicationContext().getBean(GrapBetPin111Handler.class);
		try {
			grapBetPin111Handler.grabData(1, "https://www.pin1111.com");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		logger.info("GrabBetPin111Job   end");
	}

}
