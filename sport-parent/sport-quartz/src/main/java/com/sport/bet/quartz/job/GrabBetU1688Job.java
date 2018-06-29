package com.sport.bet.quartz.job;

import java.io.UnsupportedEncodingException;
import java.time.LocalDate;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;

import com.sport.bet.datasource.handler.GrapBetU1688Handler;
import com.sport.bet.quartz.common.ApplicationContextProvider;

public class GrabBetU1688Job implements Job {

	private static Logger logger = LoggerFactory.getLogger(GrabBetU1688Job.class);
	
	private GrapBetU1688Handler grapBetU1688Handler;
	
	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
		
		logger.info("GrabBetU1688Job");
		grapBetU1688Handler = ApplicationContextProvider.getApplicationContext().getBean(GrapBetU1688Handler.class);
		
		try {
			grapBetU1688Handler.grabData(1, "http://www.u16888.com/euro/basketball/"+LocalDate.now());
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}

}
