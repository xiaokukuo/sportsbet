package com.sport.bet.common.data.structure.interfaces;

public interface IStack<S> {

	public void push(S s); // 数据入栈操作
	
	public S pop(); // 数据出栈操作
	
	public int size(); // 返回当前栈中元素个数
	
	public void clear(); // 清空栈
	
	public void isEmpty(); // 判断是否为空，若为空则返回true, 否则返回false
	
	public S top(); // 读取栈首元素
	
}
