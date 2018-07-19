package com.sport.bet.common.structure.queue;

import java.util.Arrays;
import java.util.NoSuchElementException;

@SuppressWarnings("unchecked")
public class CircleArrayQueue<E> implements IQueue<E>{

	private Object[] element=null;
    private int maxSize; //队列容量
    private int front;  //队列头，允许删除
    private int rear;   //队列尾，允许插入
    
    public CircleArrayQueue(){
    	this(10);
    }
    
    public CircleArrayQueue(int initSize){
    	if(initSize < 0){
    		throw new RuntimeException("初始化大小不能小于0：" + initSize);
    	}
    	this.maxSize = initSize;
    	element = new Object[initSize];
    	front = rear = 0;
    }
    
	@Override
	public boolean add(E e) {
		// 若循环队列未满，插入e元素为新的对尾元素; 否则队列状态不变并给出错误信息
		if((rear+1)%maxSize == front){
			return false;
			//throw new IndexOutOfBoundsException();
		}
		rear = (rear + 1)%maxSize;
		element[rear] = e;
		return true;
	}
	
	@Override
	public boolean offer(E e) {
		// 若循环队列未满，插入e元素为新的对尾元素; 否则队列状态不变并给出错误信息
		if((rear+1)%maxSize == front){
			throw new IndexOutOfBoundsException();
		}
		rear = (rear + 1)%maxSize;
		element[rear] = e;
		return true;
	}
	
	@Override
	public E poll() {
		// 若循环队列不空，则删去队头元素并返回元素
		if(isEmpty()){
			return null;
		}
		front = (front + 1)%maxSize;
		return (E) element[front];
	}
	
	@Override
	public E remove() {
		if(isEmpty()){
			throw new NullPointerException();
		}
		front = (front + 1)%maxSize;
		return (E) element[front];
	}
	
	@Override
	public E head() {
		if(isEmpty()){
			return null;
		}
		return (E) element[front];
	}
	
	@Override
	public E element() {
		if(isEmpty()){
			throw new NoSuchElementException(CircleArrayQueue.class.getName());
		}
		E value = (E) element[front];
		return value;
	}
	
	@Override
	public int length() {
		return (maxSize + rear - front)%maxSize;
	}
	
	@Override
	public boolean isEmpty() {
		return rear == front ? true : false;
	}
	
	@Override
	public void clear() {
		// 将底层数组所有元素赋为null
		Arrays.fill(element, null);
		rear = front=0;
	}
	
}
