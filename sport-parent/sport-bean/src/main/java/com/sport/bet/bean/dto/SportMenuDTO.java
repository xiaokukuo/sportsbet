package com.sport.bet.bean.dto;

public class SportMenuDTO {
	
	private int resourceId;
	
	private String sportName;
	
	private String sportPd;

	public int getResourceId() {
		return resourceId;
	}

	public void setResourceId(int resourceId) {
		this.resourceId = resourceId;
	}

	public String getSportName() {
		return sportName;
	}

	public void setSportName(String sportName) {
		this.sportName = sportName;
	}

	public String getSportPd() {
		return sportPd;
	}

	public void setSportPd(String sportPd) {
		this.sportPd = sportPd;
	}

	@Override
	public String toString() {
		return "SportMenuDTO [resourceId=" + resourceId + ", sportName=" + sportName + ", sportPd=" + sportPd + "]";
	}
	
}
