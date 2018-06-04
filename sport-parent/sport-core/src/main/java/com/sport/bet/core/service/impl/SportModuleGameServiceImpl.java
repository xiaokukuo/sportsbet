package com.sport.bet.core.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.sport.bet.bean.model.SportModuleGame;
import com.sport.bet.core.mapper.SportModuleGameMapper;
import com.sport.bet.core.service.ISportModuleGameService;

public class SportModuleGameServiceImpl implements ISportModuleGameService {

	@Autowired
	private SportModuleGameMapper sportGameMapper;
	
	@Override
	public int save(SportModuleGame game, String tbName) {
		return sportGameMapper.insert(game, tbName);
	}

}
