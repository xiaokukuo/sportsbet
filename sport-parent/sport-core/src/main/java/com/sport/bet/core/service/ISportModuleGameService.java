package com.sport.bet.core.service;

import java.util.List;

import com.sport.bet.bean.model.SportModuleGame;

public interface ISportModuleGameService {

	int save(SportModuleGame game, String tbName);
	
	void saveByBatch(List<SportModuleGame> sportModuleList, String tableName);
	
}
