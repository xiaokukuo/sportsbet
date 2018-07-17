package com.sport.bet.common.data.structure.entity;

import com.sport.bet.common.data.structure.interfaces.IStack;

/**
 * 链栈
 * @author Administrator
 *
 */
public class LinkStack<S> implements IStack<S>{

	public StackNode<S> top;
	
	public LinkStack(){
		LinkStack<S> ls = new LinkStack<S>();
		ls.top = null;
	}

	@Override
	public void push(S s) {
		StackNode<S> p = null;
		p = new StackNode<S>();
		p.data = s;
		p.next = top;
		top = p;
	}

	@Override
	public S pop() {
		//若栈不空，删除栈顶元素并返回元素值，否则返回空元素 null
		StackNode<S> p = null;
		S x;
		if(top == null){
			return null;
		}else{
			x = top.data;
			p = top;
			top = p.next;
			p = null;
			return x;
		}
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void isEmpty() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public S top() {
		// TODO Auto-generated method stub
		return null;
	}

}
