package com.sport.bet.datasouce.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import com.sport.bet.bean.model.Resource;
import com.sport.bet.bean.model.Sport;
import com.sport.bet.bean.model.SportModule;
import com.sport.bet.core.service.impl.ResourceServiceImpl;
import com.sport.bet.core.service.impl.SportModuleServiceImpl;
import com.sport.bet.core.service.impl.SportServiceImpl;

@Service
public class Bet365Service {
	
	@Autowired
	private ResourceServiceImpl resourceService;
	
	private static String TABLE_NAME = "365";
	
	@Autowired
	private SportServiceImpl sportService;
	
	@Autowired
	private SportModuleServiceImpl sportModuleService;
	
	public List<Sport> saveSportMenu(List<Sport> sportList) {
		List<Sport> sports = new ArrayList<Sport>();
		
		List<Resource> listResource = resourceService.findAll();
		Map<String, Integer> map = new HashMap<String, Integer>();
		for (Resource resource : listResource) {
			map.put(resource.getName(), resource.getId());
		}
		
		for (Sport sport : sportList) {
			if(map.containsKey(sport.getName())){
				sport.setResourceId(map.get(sport.getName()));
				sport.setTableName(TABLE_NAME);
				try {
					sportService.insert(sport);
				} catch (DuplicateKeyException e) {
					sports.add(sport);
				}
			}
		}
		return sports;
	}
	
	
	public List<SportModule> saveSportGame(List<SportModule> sportGameList) {
		
		for (SportModule sportModule : sportGameList) {
			sportModuleService.save(sportModule, "365");
		}
		
		
		return null;
	}

}
