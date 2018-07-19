package com.sport.bet.common.structure.stack;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 链栈
 * @author Administrator
 *
 */
public class LinkStack<S> implements IStack<S>{

	class StackNode {
		
		S data; // 保存节点的数据元素
		StackNode next; // 保存下一个节点的引用
		
		public StackNode(){} //无参构造函数
		
		public StackNode(S data, StackNode next){
			this.data=data;
			this.next=next;
		}

	}

	public StackNode top; // 存放栈顶节点 
	private  AtomicInteger size; //元素个数

	// 创建空链栈
	public LinkStack() {
		top = null;
		size = new AtomicInteger(0); 
	}
	
	// 已指定数据元素创建链栈，只有一个元素
	public LinkStack(S element) {
		top = new StackNode(element, null);
		size = new AtomicInteger(1); 
	}


	// 进栈
	@Override
	public void push(S s) {
		top = new StackNode(s, top);
		size.incrementAndGet();
	}


	// 出栈
	@Override
	public S pop() {
		//若栈不空，删除栈顶元素并返回元素值，否则返回空元素 null
		if(size.get() == 0){
			return null;
		}
		
		StackNode oldNode = top;
		
		S node = top.data;
		top = oldNode.next;
		
		oldNode = null; //释放引用
		size.decrementAndGet();
		return node;
	}

	//返回栈顶的元素，但不出栈
	@Override
	public S peek(){
		//若栈不空，删除栈顶元素并返回元素值，否则返回空元素 null
		if(size.get() == 0){
			return null;
		}
		return top.data;
	}
	
	@Override
	public int size() {
		//堆栈长度
		return  size.get();
	}

	@Override
	public void clear() {
		top = null;
		size.set(0);
	}

	@Override
	public boolean isEmpty() {
		return size.get() == 0;
	}
	
	public String toString() {
		// 链栈为空链栈时
		if(isEmpty())
			return "[]";
		else{
			StringBuilder sb = new StringBuilder("[");
			for (StackNode current = top; current != null; current = current.next) {
				sb.append(current.data.toString() + ", ");
			}
			int len = sb.length();
			return sb.delete(len - 2, len).append("]").toString();
		}
	}

}
