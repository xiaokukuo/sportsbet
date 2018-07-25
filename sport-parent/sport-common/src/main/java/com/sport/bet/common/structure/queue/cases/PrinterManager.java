package com.sport.bet.common.structure.queue.cases;

import com.sport.bet.common.structure.queue.LinkedQueue;

public class PrinterManager {
	
	LinkedQueue<PrintEvent> printQueue = new LinkedQueue<PrintEvent>();
	
	LinkedQueue<PrintEvent> taskQueue = new LinkedQueue<PrintEvent>();
	
	int random(){
		return (int) (Math.random()*1000);
	}
	
	public void taskStart(PrintEvent pe){
		System.err.println(pe.startTime+": task :"+pe.number+ "now begin!");
		PrintEvent temp = new PrintEvent();
		temp.type = 1;
		temp.startTime = pe.startTime + pe.durTime;
		temp.number = pe.number;
		printQueue.add(temp);
	}
	
	public void taskOver(PrintEvent pe){
		System.err.println(pe.startTime+": task:"+pe.number + "now over!");
	}

	public static void main(String[] args) {
		PrinterManager manager = new PrinterManager();
		int lastTime = 200;
		int taskNumber = 0;
		
		PrintEvent ev1 = new PrintEvent();
		ev1.number = taskNumber++;
		ev1.startTime = 0;
		ev1.durTime = manager.random();
		ev1.type = 0;
		manager.taskQueue.add(ev1);
		PrintEvent ev2 = new PrintEvent();
		ev2.number = taskNumber++;
		ev2.startTime = 1;
		ev2.durTime = manager.random();
		ev2.type = 0;
		manager.taskQueue.add(ev2);
		
		PrintEvent pe;
		while(!manager.taskQueue.isEmpty()){
			pe = manager.taskQueue.poll();
			manager.taskStart(pe);
		}
		
		for (;;) {
			pe = manager.printQueue.poll();
			if(pe != null){
				manager.taskOver(pe);
			}
		}
			
	}
}
