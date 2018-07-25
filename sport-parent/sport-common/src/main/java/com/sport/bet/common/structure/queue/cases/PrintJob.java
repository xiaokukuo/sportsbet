package com.sport.bet.common.structure.queue.cases;

public class PrintJob implements Runnable {

	PrintEvent event;
	
	
	@Override
	public void run() {
		
	}

	public PrintEvent getEvent() {
		return event;
	}


	public void setEvent(PrintEvent event) {
		this.event = event;
	}

}
