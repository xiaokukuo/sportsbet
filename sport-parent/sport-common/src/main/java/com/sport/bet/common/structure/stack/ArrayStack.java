package com.sport.bet.common.structure.stack;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 顺序栈
 * 
 * @author Administrator
 *
 */
public class ArrayStack<S> implements IStack<S> {

	private final int maxsize = 100; // 栈的最大容量

	private Object[] element;// 定义一个数组用于保存顺序栈的元素

	private AtomicInteger size; // 保存顺序栈中元素的当前个数

	private volatile int capacity;// 保存数组的长度

	public ArrayStack() {
		capacity = maxsize;
		element = new Object[capacity];
		size = new AtomicInteger(0);
	}

	public ArrayStack(int initSize) {
		capacity = initSize;
		element = new Object[capacity];
		size = new AtomicInteger(0);
	}

	public ArrayStack(S element) {
		this();
		this.element[0] = element;
		size.incrementAndGet();
	}

	@Override
	public void push(Object s) {
		ensureCapacity(size.get() + 1);
		element[size.getAndIncrement()] = s;
	}

	@SuppressWarnings("unchecked")
	@Override
	public S pop() {
		if (!isEmpty()) {
			S oldValue = (S) element[size.get() - 1];
			element[size.getAndDecrement()-1] = null; // 释放栈顶元素
			return oldValue;
		} else {
			return null;
		}
	}

	@Override
	public int size() {
		return size.get();
	}

	@Override
	public void clear() {
		// 将底层数组所有元素赋为null
		Arrays.fill(element, null);
		size.set(0);
	}

	@Override
	public boolean isEmpty() {
		return size.get() == 0;
	}

	@SuppressWarnings("unchecked")
	@Override
	public S peek() {
		if (!isEmpty()) {
			return (S) element[size.get() - 1];
		} else {
			return null;
			// throw new IndexOutOfBoundsException("空栈异常");
		}
	}

	private void ensureCapacity(int minCapacity) {
		int temp = capacity;
		// 如果数组的原有长度小于目前所需的长度
		if (minCapacity >= capacity) {
			capacity = temp * 3 / 2 + 1;
			element = Arrays.copyOf(element, capacity);
		}
	}

	public String toString() {
		if (size.get() == 0) {
			return "[]";
		} else {
			StringBuilder sb = new StringBuilder("[");
			for (int i = size.get() - 1; i > -1; i--) {
				sb.append(element[i].toString() + ", ");
			}
			int len = sb.length();
			return sb.delete(len - 2, len).append("]").toString();
		}
	}
	
	public S get(int index){
		return (S) element[index];
	}
	
	public static void main(String[] args) {
		ArrayStack<Integer> mapStack = new ArrayStack<Integer>(6);
		mapStack.push(1);
		
		System.out.println(mapStack.toString());
		System.out.println(mapStack.peek());
	}

}
