package com.sport.bet.datasource.parsing.bet365;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PreDestroy;

import com.sport.bet.datasource.parsing.AbstractPaser;

public abstract class Abstract365Paser<T> extends AbstractPaser<T>{
	
	
	protected volatile List<T> list = new ArrayList<T>();

	public List<T> getList() {
		return list;
	}

	public void setList(List<T> list) {
		this.list = list;
	}

	@PreDestroy
	private void reDestory(){
		
		System.err.println("执行了 销毁——————————————————————————————————————————————————————————");
		list.clear();
	}
}
