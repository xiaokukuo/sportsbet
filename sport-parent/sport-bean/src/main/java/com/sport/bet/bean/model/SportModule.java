package com.sport.bet.bean.model;

public class SportModule extends BaseBean {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5298370904243632295L;

	private int resourceId;
	
	private String cid; // 篮球的那个板块id

	private String groupName;

	private String gameLinesPd;

	private String firstHalfPd; //上半场

	private String secondHalfPd; //下半场
	
	private String firstQuarterPd;
	
	private String secondQuarterPd;
	
	private String thirdQuarterPd;
	
	private String fourthQuarterPd;

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

	public String getFirstQuarterPd() {
		return firstQuarterPd;
	}

	public void setFirstQuarterPd(String firstQuarterPd) {
		this.firstQuarterPd = firstQuarterPd;
	}

	public String getSecondQuarterPd() {
		return secondQuarterPd;
	}

	public void setSecondQuarterPd(String secondQuarterPd) {
		this.secondQuarterPd = secondQuarterPd;
	}

	public String getThirdQuarterPd() {
		return thirdQuarterPd;
	}

	public void setThirdQuarterPd(String thirdQuarterPd) {
		this.thirdQuarterPd = thirdQuarterPd;
	}

	public String getFourthQuarterPd() {
		return fourthQuarterPd;
	}

	public void setFourthQuarterPd(String fourthQuarterPd) {
		this.fourthQuarterPd = fourthQuarterPd;
	}

	
	public String getCid() {
		return cid;
	}

	public void setCid(String cid) {
		this.cid = cid;
	}

	@Override
	public String toString() {
		return "SportModule [resourceId=" + resourceId + ", cid=" + cid + ", groupName=" + groupName + ", gameLinesPd="
				+ gameLinesPd + ", firstHalfPd=" + firstHalfPd + ", secondHalfPd=" + secondHalfPd + ", firstQuarterPd="
				+ firstQuarterPd + ", secondQuarterPd=" + secondQuarterPd + ", thirdQuarterPd=" + thirdQuarterPd
				+ ", fourthQuarterPd=" + fourthQuarterPd + "]";
	}

}
