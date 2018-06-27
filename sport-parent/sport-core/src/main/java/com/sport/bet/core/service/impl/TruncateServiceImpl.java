package com.sport.bet.core.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sport.bet.core.mapper.TruncateMapper;

@Service
public class TruncateServiceImpl {
	
	@Autowired
	private TruncateMapper truncateMapper;
	
	public void truncateByName(String tableName){
		truncateMapper.truncateGameOdds(tableName);
		truncateMapper.truncateModule(tableName);
		truncateMapper.truncateModuleGame(tableName);
	}

}
