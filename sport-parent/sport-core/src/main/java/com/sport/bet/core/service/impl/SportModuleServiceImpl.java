package com.sport.bet.core.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sport.bet.bean.model.SportModule;
import com.sport.bet.core.mapper.SportModuleMapper;
import com.sport.bet.core.service.ISportModuleService;

@Service
public class SportModuleServiceImpl implements ISportModuleService {

	@Autowired
	private SportModuleMapper sportModuleMapper;
	
	@Override
	public int save(SportModule sportModule, String tableName) {
		return sportModuleMapper.insert(sportModule, tableName);
	}

}
