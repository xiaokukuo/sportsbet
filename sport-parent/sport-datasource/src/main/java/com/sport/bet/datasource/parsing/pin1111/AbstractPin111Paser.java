package com.sport.bet.datasource.parsing.pin1111;

import java.util.ArrayList;
import java.util.List;

import com.sport.bet.datasource.parsing.AbstractPaser;

public abstract class AbstractPin111Paser<T> extends AbstractPaser<T>{
	
	
	protected volatile List<T> list = new ArrayList<T>();

	public List<T> getList() {
		return list;
	}

	public void setList(List<T> list) {
		this.list = list;
	}
	
}
