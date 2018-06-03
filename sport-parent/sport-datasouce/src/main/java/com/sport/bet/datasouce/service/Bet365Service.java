package com.sport.bet.datasouce.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sport.bet.bean.model.SportModule;
import com.sport.bet.core.service.impl.ResourceServiceImpl;
import com.sport.bet.core.service.impl.SportModuleServiceImpl;

@Service
public class Bet365Service {
	
	@Autowired
	private ResourceServiceImpl resourceService;
	
	private static String TABLE_NAME = "365";
	
	@Autowired
	private SportModuleServiceImpl sportModuleService;
	
	public List<SportModule> saveSportGame(List<SportModule> sportGameList) {
		
		for (SportModule sportModule : sportGameList) {
			sportModuleService.save(sportModule, "365");
		}
		
		
		return null;
	}

}
