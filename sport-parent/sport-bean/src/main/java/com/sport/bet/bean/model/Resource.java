package com.sport.bet.bean.model;

public class Resource extends BaseBean{

	/**
	 * 
	 */
	private static final long serialVersionUID = 288041901996728055L;

	private String name;
	
	private String code;
	
	private String url365;
	
	private String url188;
	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getUrl365() {
		return url365;
	}

	public void setUrl365(String url365) {
		this.url365 = url365;
	}

	public String getUrl188() {
		return url188;
	}

	public void setUrl188(String url188) {
		this.url188 = url188;
	}

	
}
