package com.sport.bet.core.service;

import java.util.List;

import com.sport.bet.bean.model.SportModule;

public interface ISportModuleService {

	int save(SportModule sportModule, String tableName); 
	
	void saveByBatch(List<SportModule> sportModuleList, String tableName);
	
}
