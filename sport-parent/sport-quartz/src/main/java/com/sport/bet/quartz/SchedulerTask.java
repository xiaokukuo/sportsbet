package com.sport.bet.quartz;

import org.quartz.CronScheduleBuilder;
import org.quartz.CronTrigger;
import org.quartz.Job;
import org.quartz.JobBuilder;
import org.quartz.JobDataMap;
import org.quartz.JobDetail;
import org.quartz.JobExecutionException;
import org.quartz.JobKey;
import org.quartz.Scheduler;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.TriggerKey;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;

import com.sport.bet.quartz.task.BatchTaskInfo;

/*
@Component // 此注解必加  

*/
/*@Component // 此注解必加  
@EnableScheduling // 此注解必加
*/
@Configuration
public class SchedulerTask {

	// @Autowired可以使用spring的bean

	/**
	 * 发送告警通知
	 */

	@Autowired
	private SchedulerFactoryBean schedulerFactory;

	public void execute() throws JobExecutionException, Exception {
		Scheduler scheduler = schedulerFactory.getScheduler();
		
		BatchTaskInfo task = new BatchTaskInfo();
		task.setId("12345678");
		task.setTaskName("Job1");
		task.setTaskGroup("group1");
		task.setCron("0/2 * * * * ?");
		task.setClassName("com.msa.framework.batch.quartz.job.SimpleJob");
		
		BatchTaskInfo task1 = new BatchTaskInfo();
		task1.setId("1234567wewe8");
		task1.setTaskName("Job12222");
		task1.setTaskGroup("group1222");
		task1.setCron("0/2 * * * * ?");
		task1.setClassName("com.msa.framework.batch.quartz.job.JobA");
		flushJob(task, scheduler);
		scheduler = schedulerFactory.getScheduler();
		flushJob(task1, scheduler);
	}

	private void flushJob(BatchTaskInfo task,Scheduler scheduler) throws Exception {
		
		TriggerKey triggerKey = TriggerKey.triggerKey(task.getTaskName(),task.getTaskGroup());
		Trigger trigger1 = scheduler.getTrigger(triggerKey);
		
		boolean isNew = true;// 是否为新任务
		if (trigger1 != null) {
			isNew = false;
		}
		if (isNew) {
			System.err.println("创建一个新任务");
			addJob(task, scheduler);
		}else{
			
			JobKey jobKey = JobKey.jobKey(task.getTaskName(),task.getTaskGroup());
			JobDataMap jdm = scheduler.getJobDetail(jobKey).getJobDataMap();
			String  oldCron =  (String) jdm.get("jobScheduler");
			if (oldCron.equals(task.getCron())) {
				System.err.println("任务不变");
			}else{
				deleteJob(task, scheduler);
				System.err.println("任务执行时间改变");
			}
		}

	}
	
	private void deleteJob(BatchTaskInfo task,Scheduler scheduler) throws Exception {
		JobKey jobKey = JobKey.jobKey(task.getTaskName(),task.getTaskGroup());
		scheduler.deleteJob(jobKey);
	}
	
	@SuppressWarnings({ "unchecked" })
	private void addJob(BatchTaskInfo task,Scheduler scheduler) throws Exception {
		Class<Job> clazz;
		try {
			clazz = (Class<Job>) Class.forName(task.getClassName());
		} catch (ClassNotFoundException e1) {
			return;
		}
		JobDetail jobDetail = JobBuilder.newJob(clazz)
				.withIdentity(task.getTaskName(), task.getTaskGroup())
				.build();
		jobDetail.getJobDataMap().put("jobScheduler",task.getCron());
		CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule(task.getCron());
		CronTrigger trigger = TriggerBuilder.newTrigger()
				.withIdentity(task.getTaskName(), task.getTaskGroup())
				.withSchedule(scheduleBuilder).build();
		scheduler.scheduleJob(jobDetail, trigger);
		System.err.println("任务["+task.getTaskName()+"], 构建Quartz任务成功, cron["+task.getCron()+"]");
	}

}
