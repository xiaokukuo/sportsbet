package com.sport.bet.bean.model;

public class SportModuleGame extends BaseBean {

	private static final long serialVersionUID = 4703139339492040458L;

	private int resourceId;
	
	private int sportGroupId;
	
	private String cid; // 篮球的那个板块id
	
	private String eid; // 篮球板块中队伍Id

	private String teamName1;

	private String teamName2;

	private String deailPd;

	private String gameTime;
	
	public int getResourceId() {
		return resourceId;
	}

	public void setResourceId(int resourceId) {
		this.resourceId = resourceId;
	}

	public int getSportGroupId() {
		return sportGroupId;
	}

	public void setSportGroupId(int sportGroupId) {
		this.sportGroupId = sportGroupId;
	}

	public String getTeamName1() {
		return teamName1;
	}

	public void setTeamName1(String teamName1) {
		this.teamName1 = teamName1;
	}

	public String getTeamName2() {
		return teamName2;
	}

	public void setTeamName2(String teamName2) {
		this.teamName2 = teamName2;
	}

	public String getDeailPd() {
		return deailPd;
	}

	public void setDeailPd(String deailPd) {
		this.deailPd = deailPd;
	}

	public String getGameTime() {
		return gameTime;
	}

	public void setGameTime(String gameTime) {
		this.gameTime = gameTime;
	}

	public String getEid() {
		return eid;
	}

	public void setEid(String eid) {
		this.eid = eid;
	}

	public String getCid() {
		return cid;
	}

	public void setCid(String cid) {
		this.cid = cid;
	}

	@Override
	public String toString() {
		return "SportModuleGame [resourceId=" + resourceId + ", sportGroupId=" + sportGroupId + ", cid=" + cid
				+ ", eid=" + eid + ", teamName1=" + teamName1 + ", teamName2=" + teamName2 + ", deailPd=" + deailPd
				+ ", gameTime=" + gameTime + "]";
	}

	
}
