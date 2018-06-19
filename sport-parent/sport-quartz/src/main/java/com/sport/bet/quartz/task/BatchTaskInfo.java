package com.sport.bet.quartz.task;

import java.io.Serializable;

public class BatchTaskInfo implements Serializable{

	private static final long serialVersionUID = -7326609834401508499L;

	private String id;
	
	private String taskName;
	
	private String taskGroup;
	
	private String taskType;//任务类型
	
	private String className;//class name
	
	private String cron;//cron表达式

	public String getId() {
		return id;
	}

	public void setId(String id) {
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

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public String getCron() {
		return cron;
	}

	public void setCron(String cron) {
		this.cron = cron;
	}
	
	
}
