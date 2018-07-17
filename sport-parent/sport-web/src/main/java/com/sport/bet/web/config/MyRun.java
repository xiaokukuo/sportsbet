package com.sport.bet.web.config;

public class MyRun implements Runnable {

	private String name;

	// private MethodSync methodSync = new MethodSync();

	public MyRun(String name){
        this.name = name;
    }

	public void run() {
		addg();
	}
	
	public synchronized void addg(){
		System.out.println(this.getClass()+"---"+this.name + " IN synchronized (anyString)同步代码块");
        System.out.println(this.getClass()+"---"+this.name + " OUT synchronized (anyString)同步代码块");
	}
}
