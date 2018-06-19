/*package com.sport.bet.quartz.listener;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.JobListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sport.bet.quartz.common.JobResult;

public class MyJobListener implements JobListener {
	private static Logger _log = LoggerFactory.getLogger(MyJobListener.class);

	public String getName() {
		return "job1_to_job2";
	}

	public void jobToBeExecuted(JobExecutionContext inContext) {
		_log.info("Job1Listener says: Job Is about to be executed.");
	}

	public void jobExecutionVetoed(JobExecutionContext inContext) {
		_log.info("Job1Listener says: Job Execution was vetoed.");
	}

	public void jobWasExecuted(JobExecutionContext inContext, JobExecutionException inException) {
		
		JobResult result = (JobResult) inContext.getResult();
		
		if(!result.isSuccess()){
			_log.info("Job1Listener says: Job1 was faile.");
			return;
		}

	}
}
*/