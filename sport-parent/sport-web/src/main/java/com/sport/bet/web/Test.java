package com.sport.bet.web;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Test {
	
	public static void main(String[] args) {
		AtomicInteger a = new AtomicInteger();
		
		List<Integer> al = new ArrayList<Integer>();
		
		ReentrantLock lock = new ReentrantLock();
		
		ReentrantReadWriteLock readwriter = new ReentrantReadWriteLock();
	}

}
