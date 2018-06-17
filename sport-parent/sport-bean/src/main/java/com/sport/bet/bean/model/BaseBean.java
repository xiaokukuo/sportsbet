package com.sport.bet.bean.model;

import java.io.Serializable;
import java.util.Date;

public class BaseBean implements Serializable {

	private static final long serialVersionUID = -8335524559221845087L;

	protected int id;
	
	protected Date createTime;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

}
