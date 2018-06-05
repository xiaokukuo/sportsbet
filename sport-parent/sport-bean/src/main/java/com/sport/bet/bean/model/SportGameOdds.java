package com.sport.bet.bean.model;

public class SportGameOdds extends BaseBean {
	
	private int gameId;
	
	private int scoreType;
	
	private int score;
	
	private String oneOrHigher;
	
	private String twoOrLower;
	
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

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
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

}
