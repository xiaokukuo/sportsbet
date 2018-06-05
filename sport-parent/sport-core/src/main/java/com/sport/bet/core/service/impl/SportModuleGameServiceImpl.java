package com.sport.bet.core.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sport.bet.bean.model.SportModuleGame;
import com.sport.bet.core.mapper.SportModuleGameMapper;
import com.sport.bet.core.service.ISportModuleGameService;

@Service
public class SportModuleGameServiceImpl implements ISportModuleGameService {

	@Autowired
	private SportModuleGameMapper sportGameMapper;
	
	@Override
	public int save(SportModuleGame game, String tbName) {
		return sportGameMapper.insert(game, tbName);
	}

	@Override
	public void saveByBatch(List<SportModuleGame> sportModuleList, String tableName) {
		sportGameMapper.insertByBatch(sportModuleList, tableName);
	}

}
