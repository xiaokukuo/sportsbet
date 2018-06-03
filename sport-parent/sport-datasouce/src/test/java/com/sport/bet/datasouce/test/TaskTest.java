package com.sport.bet.datasouce.test;

import org.junit.Test;

import com.sport.bet.datasouce.task.Bet365Task;
import com.sport.bet.datasouce.test.base.BaseTest;

public class TaskTest extends BaseTest{

	@Test
	public void findAllTest (){
		 Bet365Task rtt = new Bet365Task();
	     new Thread(rtt, "新线程1").start();
	}
	
}
