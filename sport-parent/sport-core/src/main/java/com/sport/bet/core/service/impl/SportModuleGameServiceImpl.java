package com.sport.bet.core.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sport.bet.bean.model.SportModuleGame;
import com.sport.bet.core.common.general.GeneralMapper;
import com.sport.bet.core.common.general.GeneralServiceImpl;
import com.sport.bet.core.mapper.SportModuleGameMapper;

@Service
public class SportModuleGameServiceImpl extends GeneralServiceImpl<SportModuleGame> {

	@Autowired
	private SportModuleGameMapper sportModuleGameMapper;

	@Override
	public GeneralMapper<SportModuleGame> getGeneralMapper() {
		return sportModuleGameMapper;
	}
	
}
