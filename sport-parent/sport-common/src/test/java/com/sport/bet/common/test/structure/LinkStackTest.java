package com.sport.bet.common.test.structure;

import java.util.Stack;
import java.util.concurrent.locks.ReentrantLock;

import com.sport.bet.common.structure.stack.LinkStack;

public class LinkStackTest {
	
	public static void main(String[] args) throws InterruptedException {
		LinkStack<Integer> linkStack = new LinkStack<Integer>();
		
		ReentrantLock lock = new ReentrantLock();
		
		Thread thread1 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				for (int i = 0; i < 20; i++) {
					lock.lock();
					linkStack.push(i);
					lock.unlock();
				}
			}
		});
		
		Thread thread2 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				for (int j = 20; j < 40; j++) {
					lock.lock();
					linkStack.push(j);
					lock.unlock();
				}
			}
		});
		thread1.start();
		thread2.start();
		
		Thread.sleep(4000);
		System.out.println(linkStack.toString());
		System.out.println(linkStack.size());
		
	}
	
}


