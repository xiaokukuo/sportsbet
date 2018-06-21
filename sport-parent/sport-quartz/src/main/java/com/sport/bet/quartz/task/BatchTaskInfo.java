package com.sport.bet.quartz.task;

import java.io.Serializable;
import java.sql.Time;

public class BatchTaskInfo implements Serializable{

	private static final long serialVersionUID = -7326609834401508499L;

	private int id;
	
	private String taskName;
	
	private String taskGroup;
	
	private String taskType;//任务类型
	
	private String cron;//cron表达式
	
	private String className;//class name
	
	private String status;//状态
	
	private Time lastestTime;//最迟执行时间

	private String desc;//任务描述

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTaskName() {
		return taskName;
	}

	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}

	public String getTaskGroup() {
		return taskGroup;
	}

	public void setTaskGroup(String taskGroup) {
		this.taskGroup = taskGroup;
	}

	public String getTaskType() {
		return taskType;
	}

	public void setTaskType(String taskType) {
		this.taskType = taskType;
	}

	public String getCron() {
		return cron;
	}

	public void setCron(String cron) {
		this.cron = cron;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Time getLastestTime() {
		return lastestTime;
	}

	public void setLastestTime(Time lastestTime) {
		this.lastestTime = lastestTime;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

}
