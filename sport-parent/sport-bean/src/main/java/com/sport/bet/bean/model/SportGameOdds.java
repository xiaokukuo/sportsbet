package com.sport.bet.bean.model;

public class SportGameOdds extends BaseBean {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7610480322189511109L;

	private int gameId;
	
	private String cid;
	
	private String eid;
	
	private int scoreType; // 1:让分，2：总分，3：强弱盘

	private String score; // 总分

	private String higher; 

	private String lower; 
	
	private String team; //队伍名称
	
	private String team2; //队伍名称

	private String teamNa; // 让分系数

	private String teamScore; // 让分

	private String singleWinerScore; // 强弱盘
	
	public int getGameId() {
		return gameId;
	}

	public void setGameId(int gameId) {
		this.gameId = gameId;
	}

	public int getScoreType() {
		return scoreType;
	}

	public void setScoreType(int scoreType) {
		this.scoreType = scoreType;
	}

	public String getScore() {
		return score;
	}

	public void setScore(String score) {
		this.score = score;
	}

	public String getHigher() {
		return higher;
	}

	public void setHigher(String higher) {
		this.higher = higher;
	}

	public String getLower() {
		return lower;
	}

	public void setLower(String lower) {
		this.lower = lower;
	}

	public String getTeam() {
		return team;
	}

	public void setTeam(String team) {
		this.team = team;
	}

	public String getTeam2() {
		return team2;
	}

	public void setTeam2(String team2) {
		this.team2 = team2;
	}

	public String getTeamNa() {
		return teamNa;
	}

	public void setTeamNa(String teamNa) {
		this.teamNa = teamNa;
	}

	public String getTeamScore() {
		return teamScore;
	}

	public void setTeamScore(String teamScore) {
		this.teamScore = teamScore;
	}

	public String getSingleWinerScore() {
		return singleWinerScore;
	}

	public void setSingleWinerScore(String singleWinerScore) {
		this.singleWinerScore = singleWinerScore;
	}

	public String getCid() {
		return cid;
	}

	public void setCid(String cid) {
		this.cid = cid;
	}

	public String getEid() {
		return eid;
	}

	public void setEid(String eid) {
		this.eid = eid;
	}

	@Override
	public String toString() {
		return "SportGameOdds [gameId=" + gameId + ", cid=" + cid + ", eid=" + eid + ", scoreType=" + scoreType
				+ ", score=" + score + ", higher=" + higher + ", lower=" + lower + ", team=" + team + ", teamNa="
				+ teamNa + ", teamScore=" + teamScore + ", singleWinerScore=" + singleWinerScore + "]";
	}
	
}
