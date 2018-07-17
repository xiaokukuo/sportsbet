package com.sport.bet.web.config;

public class MyThread {
	
	public static void main(String[] args) {
		Thread thread1 = new Thread(new MyRun("Test1"));
		
		Thread thread2 = new Thread(new MyRun("Test2"));
		
		thread1.start();
		thread2.start();
	}

}
