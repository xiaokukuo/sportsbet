package com.sport.bet.core.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sport.bet.bean.model.SportModule;
import com.sport.bet.core.common.general.GeneralMapper;
import com.sport.bet.core.common.general.GeneralServiceImpl;
import com.sport.bet.core.mapper.SportModuleMapper;

@Service
public class SportModuleServiceImpl extends GeneralServiceImpl<SportModule> {

	@Autowired
	private SportModuleMapper sportModuleMapper;

	@Override
	public GeneralMapper<SportModule> getGeneralMapper() {
		return sportModuleMapper;
	}

	
}
