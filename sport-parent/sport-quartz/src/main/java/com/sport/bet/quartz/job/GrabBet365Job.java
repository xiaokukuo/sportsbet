package com.sport.bet.quartz.job;

import java.io.UnsupportedEncodingException;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sport.bet.datasource.handler.GrapBet365Handler;
import com.sport.bet.quartz.common.ApplicationContextProvider;

public class GrabBet365Job implements Job {
	
	private static Logger logger = LoggerFactory.getLogger(GrabBet365Job.class);

	private GrapBet365Handler grapBet365Handler;
	
	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
		logger.info("GrabBet365Job");
		grapBet365Handler = ApplicationContextProvider.getApplicationContext().getBean(GrapBet365Handler.class);
		try {
			grapBet365Handler.grabData(1, "https://www.365sport365.com/SportsBook.API/web?lid=10&zid=0&pd=%23AS%23B18%23&cid=42&ctid=42");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
