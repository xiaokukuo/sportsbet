package com.sport.bet.bean.model;

public class SportModule extends BaseBean {

	private int resourceId;

	private String groupName;

	private String gameLinesPd;

	private String firstHalfPd;

	private String secondHalfPd;

	public int getResourceId() {
		return resourceId;
	}

	public void setResourceId(int resourceId) {
		this.resourceId = resourceId;
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public String getGameLinesPd() {
		return gameLinesPd;
	}

	public void setGameLinesPd(String gameLinesPd) {
		this.gameLinesPd = gameLinesPd;
	}

	public String getFirstHalfPd() {
		return firstHalfPd;
	}

	public void setFirstHalfPd(String firstHalfPd) {
		this.firstHalfPd = firstHalfPd;
	}

	public String getSecondHalfPd() {
		return secondHalfPd;
	}

	public void setSecondHalfPd(String secondHalfPd) {
		this.secondHalfPd = secondHalfPd;
	}

}
