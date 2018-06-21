package com.sport.bet.quartz.job;

import java.io.Serializable;
import java.util.Date;

import org.quartz.DisallowConcurrentExecution;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.JobKey;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sport.bet.bean.model.Resource;
import com.sport.bet.core.service.impl.ResourceServiceImpl;
import com.sport.bet.quartz.common.ApplicationContextProvider;

@DisallowConcurrentExecution
public class JobA implements Job,Serializable {
	
	private static final long serialVersionUID = -4606059280525720090L;
	private static Logger _log = LoggerFactory.getLogger(JobA.class);

	private volatile static Resource commonResource = new Resource();
	
	public static String url;
	
	static{
		ResourceServiceImpl resourceService = ApplicationContextProvider.getApplicationContext().getBean(ResourceServiceImpl.class);
		commonResource = resourceService.findById(1, null);
	}
	
	public void execute(JobExecutionContext context) throws JobExecutionException {
		JobKey jobKey = context.getJobDetail().getKey();
		_log.info("JobA says: " + jobKey + " executing at " + new Date());
		
		
		System.err.println("JobA  "+ commonResource.getCode());
	}

	public static Resource getCommonresource() {
		return commonResource;
	}

	public static void setCommonResource(Resource commonResource) {
		JobA.commonResource = commonResource;
	}
	
}
