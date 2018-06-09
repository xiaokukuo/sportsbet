package com.sport.bet.core.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sport.bet.bean.model.SportGameOdds;
import com.sport.bet.core.common.general.GeneralMapper;
import com.sport.bet.core.common.general.GeneralServiceImpl;
import com.sport.bet.core.mapper.SportGameOddsMapper;

@Service
public class SportGameOddsServiceImpl extends GeneralServiceImpl<SportGameOdds>{

	@Autowired
	private SportGameOddsMapper sportGameOddsMapper;

	@Override
	public GeneralMapper<SportGameOdds> getGeneralMapper() {
		return sportGameOddsMapper;
	}

}
