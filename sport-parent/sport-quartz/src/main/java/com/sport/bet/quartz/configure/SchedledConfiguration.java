package com.sport.bet.quartz.configure;

import java.io.IOException;
import java.io.Serializable;
import java.util.Properties;

import org.springframework.beans.factory.config.PropertiesFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.scheduling.quartz.CronTriggerFactoryBean;
import org.springframework.scheduling.quartz.MethodInvokingJobDetailFactoryBean;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;

import com.sport.bet.quartz.SchedulerTask;

@Configuration
public class SchedledConfiguration implements Serializable{
	private static final long serialVersionUID = 4067226730947086867L;

	/**
	 * attention: Details：配置定时任务
	 */
	@Bean(name = "jobDetail")
	public MethodInvokingJobDetailFactoryBean detailFactoryBean(SchedulerTask task) {// ScheduleTask为需要执行的任务
		MethodInvokingJobDetailFactoryBean jobDetail = new MethodInvokingJobDetailFactoryBean();

		jobDetail.setConcurrent(false);// 是否并发执行
		jobDetail.setName("sportBetGrapJob");// 设置任务的名字
		jobDetail.setGroup("sportBetGrapJobGroup");// 设置任务的分组，这些属性都可以存储在数据库中，在多任务的时候使用
		/*
		 * 为需要执行的实体类对应的对象
		 */
		jobDetail.setTargetObject(task);
		/*
		 * 添加需要执行的方法
		 * 通过这几个配置，告诉JobDetailFactoryBean我们需要执行定时执行ScheduleTask类中的需要执行方法
		 */
		jobDetail.setTargetMethod("execute");
		return jobDetail;
	}

	/**
	 * attention: Details：配置定时任务的触发器，也就是什么时候触发执行定时任务
	 */
	@Bean(name = "jobTrigger")
	public CronTriggerFactoryBean cronJobTrigger(MethodInvokingJobDetailFactoryBean jobDetail) {
		CronTriggerFactoryBean tigger = new CronTriggerFactoryBean();
		tigger.setJobDetail(jobDetail.getObject());
		tigger.setCronExpression("0/5 * * * * ?");// 初始时的cron表达式 ，没5分钟执行一次
		tigger.setName("osportBetGrapTrigger");// trigger的name
		return tigger;

	}
	
	/** 
     * attention: 
     * Details：定义quartz调度工厂 
     */  
	 @Bean
	 public SchedulerFactoryBean schedulerFactory(CronTriggerFactoryBean cronTriggerBean)throws IOException  {
		SchedulerFactoryBean schedulerFactory = new SchedulerFactoryBean();
		// 用于quartz集群,QuartzScheduler 启动时更新己存在的Job
		schedulerFactory.setOverwriteExistingJobs(true);
		// 延时启动，应用启动1秒后
		schedulerFactory.setStartupDelay(2);
		schedulerFactory.setTriggers(cronTriggerBean.getObject());
		schedulerFactory.setQuartzProperties(quartzProperties());

		return schedulerFactory;
	}
	
	@Bean
    public Properties quartzProperties() throws IOException {
		 PropertiesFactoryBean propertiesFactoryBean = new PropertiesFactoryBean();
	        
	        Resource resource = new ClassPathResource("/quartz.properties");
	        
	        propertiesFactoryBean.setLocation(resource);
	        
	        //在quartz.properties中的属性被读取并注入后再初始化对象
	        propertiesFactoryBean.afterPropertiesSet();
	        return propertiesFactoryBean.getObject();
    }
    
   /* @Bean
    public QuartzInitializerListener executorListener() {
       return new QuartzInitializerListener();
    }*/

}
