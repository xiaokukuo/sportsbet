package com.sport.bet.bean.model;

public class SportGameOdds extends BaseBean {
	
	private int gameId;
	
	private int scoreType; //1:让分，2：总分
	
	private String score;
	
	private String oneOrHigher;
	
	private String twoOrLower;
	
	private String team1;
	
	private String team2;
	
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

	public String getOneOrHigher() {
		return oneOrHigher;
	}

	public void setOneOrHigher(String oneOrHigher) {
		this.oneOrHigher = oneOrHigher;
	}

	public String getTwoOrLower() {
		return twoOrLower;
	}

	public void setTwoOrLower(String twoOrLower) {
		this.twoOrLower = twoOrLower;
	}

	public String getTeam1() {
		return team1;
	}

	public void setTeam1(String team1) {
		this.team1 = team1;
	}

	public String getTeam2() {
		return team2;
	}

	public void setTeam2(String team2) {
		this.team2 = team2;
	}

	@Override
	public String toString() {
		return "SportGameOdds [gameId=" + gameId + ", scoreType=" + scoreType + ", score=" + score + ", oneOrHigher="
				+ oneOrHigher + ", twoOrLower=" + twoOrLower + ", team1=" + team1 + ", team2=" + team2 + "]";
	}
	

}
