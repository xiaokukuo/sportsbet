package com.sport.bet.core.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sport.bet.bean.model.SportGameOdds;
import com.sport.bet.core.common.general.GeneralMapper;
import com.sport.bet.core.common.general.GeneralServiceImpl;
import com.sport.bet.core.mapper.SportGameOddsMapper;
import com.sport.bet.core.service.ISportGameOddsService;

@Service
public class SportGameOddsServiceImpl extends GeneralServiceImpl<SportGameOdds> implements ISportGameOddsService {

	@Autowired
	private SportGameOddsMapper sportGameOddsMapper;

	@Override
	public GeneralMapper<SportGameOdds> getGeneralMapper() {
		return sportGameOddsMapper;
	}

	@Override
	public List<SportGameOdds> listJoinGameByEid(int gameId, String eid, String tableName) {
		
		return sportGameOddsMapper.selectJoinGameByEidOrGameId(gameId, eid, tableName);
	}

}
