package com.sport.bet.common.structure.queue;

import java.util.Arrays;

@SuppressWarnings("unchecked")
public class ArrayQueue<E> implements IQueue<E> {
	
	private static int defaultSize = 16; //默认容量
    private volatile int capacity;// 保存数组的长度
    
    private boolean isCapacity = true; //是否扩容
    
    private Object[] element; // 存储队列数据
    private int front = 0;  //队列头，允许删除
    private int rear = 0;   //队列尾，允许插入
    
    public ArrayQueue(){
    	capacity = defaultSize;
    	element = new Object[defaultSize];
    }
    
    public ArrayQueue(int initSize){
    	if(initSize < 0){
    		throw new RuntimeException("队列容量不能小于0");
    	}
    	capacity = initSize;
    	element = new Object[initSize];
    	this.isCapacity = false;
    }	

	@Override
	public boolean add(E e) {
		if(isCapacity){
			ensureCapacity(length() + 1);
		}
		if(rear > capacity-1){
			return false;
		}
		element[rear++] = e;
		return true;
	}

	@Override
	public boolean offer(E e) {
		if(isCapacity){
			ensureCapacity(length() + 1);
		}
		if(rear > capacity-1){
			throw new NullPointerException();
		}
		element[rear++] = e;
		return true;
	}

	@Override
	public E poll() {
		if (isEmpty()) return null;
        E queue = (E)element[0];
        System.arraycopy(element, 1, element, 0, length()-1);
        rear--;
        return queue;
	}

	@Override
	public E head() {
		if (isEmpty()) return null;
        return (E)element[0];
	}

	@Override
	public E remove() {
		if (isEmpty()) throw new NullPointerException();
        E data = (E)element[0];
        System.arraycopy(element, 1, element, 0, length()-1);
        rear--;
        return data;
	}

	@Override
	public E element() {
		if (isEmpty()) throw new NullPointerException();
		return (E)element[0];
	}

	@Override
	public int length() {
		return rear - front;
	}

	@Override
	public boolean isEmpty() {
		return rear == front;
	}

	@Override
	public void clear() {
		// 将底层数组所有元素赋为null
		Arrays.fill(element, null);
		rear = front;
	}
	
	private void ensureCapacity(int size) {
        if (size > capacity) {
        	capacity = capacity*3/2 + 1;
            element = Arrays.copyOf(element, capacity);
        }
    }
	
	public String toString() {
		if (isEmpty()) {
			return "[]";
		} else {
			StringBuilder sb = new StringBuilder("[");
			for (int i = length() - 1; i > -1; i--) {
				sb.append(element[i].toString() + ", ");
			}
			int len = sb.length();
			return sb.delete(len - 2, len).append("]").toString();
		}
	}
	
	public static void main(String[] args) {
		ArrayQueue<Integer> sd = new ArrayQueue<>();
		
		for (int i = 0; i < 16; i++) {
			System.out.println(i+" "+sd.add(i));
		}
		System.out.println(sd.capacity);
		for (int i = 0; i < 17; i++) {
			System.out.println(sd.poll()+"  "+sd.length());
		}
		
	}

}
