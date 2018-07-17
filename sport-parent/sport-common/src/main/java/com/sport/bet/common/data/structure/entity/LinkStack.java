package com.sport.bet.common.data.structure.entity;

import com.sport.bet.common.data.structure.interfaces.IStack;

/**
 * 链栈
 * @author Administrator
 *
 */
public class LinkStack<S> implements IStack<S>{
	
	class StackNode {
		
		S data;
		StackNode next;
		//无参构造函数
		public StackNode(){}
		
		public StackNode(S data, StackNode next){
			this.data=data;
			this.next=next;
		}

	}

	public StackNode top;
	
	private  int size; //元素个数


	@Override
	public void push(S s) {
		top = new StackNode(s, top);
		size++;
	}

	@Override
	public S pop() {
		//若栈不空，删除栈顶元素并返回元素值，否则返回空元素 null
		StackNode oldNode = null;
		S node;
		if(top == null){
			return null;
		}else{
			node = top.data;
			oldNode = top;
			top = oldNode.next;
			oldNode = null; //释放引用
			size--;
			return node;
		}
	}

	//返回栈顶的元素，但不出栈
	@Override
	public S peek(){
		return top.data;
	}
	
	@Override
	public int size() {
		//堆栈长度
		return  size;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	@Override
	public S top() {
		// TODO Auto-generated method stub
		return null;
	}

}
