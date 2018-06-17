package com.sport.bet.core.service;

import java.util.List;

import com.sport.bet.bean.model.SportGameOdds;

public interface ISportGameOddsService {
	
	List<SportGameOdds> listJoinGameByEid(int gameId, String eid, String tableName);

}
