package com.sport.bet.datasource.enums;

public enum EnumSportType {

	SOCCER("足球", "soccer"), 
	
	Basketball("篮球", "basketball"),
	ESPORTS("篮球", "e-sports");
	
	// 成员变量
	private String code;
	
	private String name;
	

	// 构造方法
	private EnumSportType(String name, String code) {
		this.name = name;
		this.code = code;
	}

	// 普通方法
	public static String getName(String code) {
		for (EnumSportType c : EnumSportType.values()) {
			if (c.getcode() == code) {
				return c.name;
			}
		}
		return null;
	}

	// get set 方法
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getcode() {
		return code;
	}

	public void setcode(String code) {
		this.code = code;
	}

}
