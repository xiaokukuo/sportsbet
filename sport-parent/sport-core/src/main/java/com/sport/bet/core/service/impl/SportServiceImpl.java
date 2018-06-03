package com.sport.bet.core.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sport.bet.bean.model.Sport;
import com.sport.bet.core.mapper.SportMapper;
import com.sport.bet.core.service.ISportService;

@Service
public class SportServiceImpl implements ISportService {

	@Autowired
	private SportMapper sportMapper;
	
	@Override
	public List<Sport> findAll(String tableName) {
		return sportMapper.selectAll(tableName);
	}

	@Override
	public int insert(Sport sport) {
		return sportMapper.insert(sport);
	}

	@Override
	public int findIdByName(String name, String tableName) {
		
		return sportMapper.selectIdByName(name, tableName);
	}

	@Override
	public String findPdByResourceId(Integer reousrceId, String tableName) {
		return sportMapper.selectPdByResourceId(reousrceId, tableName);
	}

}
