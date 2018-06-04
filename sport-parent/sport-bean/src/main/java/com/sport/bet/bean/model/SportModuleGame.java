package com.sport.bet.bean.model;

public class SportModuleGame extends BaseBean {

	private int resourceId;
	
	private int sprotGroupId;

	private String teamName1;

	private String teamName2;

	private String deailPd;

	private String gameType;

	private String gameTime;
	
	public int getResourceId() {
		return resourceId;
	}

	public void setResourceId(int resourceId) {
		this.resourceId = resourceId;
	}

	public int getSprotGroupId() {
		return sprotGroupId;
	}

	public void setSprotGroupId(int sprotGroupId) {
		this.sprotGroupId = sprotGroupId;
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

	public String getGameType() {
		return gameType;
	}

	public void setGameType(String gameType) {
		this.gameType = gameType;
	}

	public String getGameTime() {
		return gameTime;
	}

	public void setGameTime(String gameTime) {
		this.gameTime = gameTime;
	}

	@Override
	public String toString() {
		return "SportModuleGame [sprotGroupId=" + sprotGroupId + ", teamName1=" + teamName1 + ", teamName2=" + teamName2
				+ ", deailPd=" + deailPd + ", gameType=" + gameType + ", gameTime=" + gameTime + "]";
	}

}
