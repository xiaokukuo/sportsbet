package com.sport.bet.common.structure.queue;

import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.Queue;

@SuppressWarnings("unchecked")
public class CicleArrayQueue<E> implements IQueue<E>{

	private Object[] data=null;
    private int maxSize; //队列容量
    private int front;  //队列头，允许删除
    private int rear;   //队列尾，允许插入
    
    public CicleArrayQueue(){
    	this(10);
    }
    
    public CicleArrayQueue(int initSize){
    	if(initSize < 0){
    		throw new RuntimeException("初始化大小不能小于0：" + initSize);
    	}
    	this.maxSize = initSize;
    	data = new Object[initSize];
    	front = rear = 0;
    }
    
	@Override
	public boolean add(E e) {
		if(rear >= maxSize){
			return false;
		}
		data[rear++] = e;
		return true;
	}
	
	@Override
	public boolean offer(E e) {
		if(rear >= maxSize){
			throw new NullPointerException();
		}
		data[rear++] = e;
		return true;
	}
	
	@Override
	public E poll() {
		if(isEmpty()){
			return null;
		}
		E value = (E)data[front]; // 保留队列的front端的元素的值
		System.arraycopy(data, 1, data, 0, length()-1);
		return value;
	}
	
	@Override
	public E remove() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public E peek() {
		if(isEmpty()){
			return null;
		}
		return (E) data[front];
	}
	
	@Override
	public E element() {
		if(isEmpty()){
			throw new NoSuchElementException(CicleArrayQueue.class.getName());
		}
		E value = (E) data[front];
		return value;
	}
	
	@Override
	public int length() {
		return rear - front;
	}
	
	@Override
	public boolean isEmpty() {
		return rear == front ? true : false;
	}
	
	@Override
	public void clear() {
		// TODO Auto-generated method stub
		
	}
	
	public static void main(String[] args) {
	}
	
	private void ensureCapacity(int size) {
        if (size > data.length) {
            int len = data.length + 10;
            data = Arrays.copyOf(data, len);
        }
    }
	
}
