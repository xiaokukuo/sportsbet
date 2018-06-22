package com.sport.bet.bean.model;

public class SportModule extends BaseBean {
	
	private static final long serialVersionUID = 5298370904243632295L;

	private int resourceId;
	
	private String cid; // 篮球的那个板块id
	
	private String groupName;
	
	private String groupItemName;

	private String gameLinesPd;
	
	/*private String firstHalfPd; //上半场

	private String secondHalfPd; //下半场
	
	private String firstQuarterPd;
	
	private String secondQuarterPd;
	
	private String thirdQuarterPd;
	
	private String fourthQuarterPd;*/

	public int getResourceId() {
		return resourceId;
	}

	public void setResourceId(int resourceId) {
		this.resourceId = resourceId;
	}

	public String getGroupName() {
		return groupName;
	}

	public String getGroupItemName() {
		return groupItemName;
	}

	public void setGroupItemName(String groupItemName) {
		this.groupItemName = groupItemName;
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

	public String getCid() {
		return cid;
	}

	public void setCid(String cid) {
		this.cid = cid;
	}

	@Override
	public String toString() {
		return "SportModule [resourceId=" + resourceId + ", cid=" + cid + ", groupName=" + groupName
				+ ", groupItemName=" + groupItemName + ", gameLinesPd=" + gameLinesPd + "]";
	}

}
