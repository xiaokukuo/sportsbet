package com.sport.bet.core.service;

import com.sport.bet.bean.model.Resource;

public interface IResourceService {
	
	int getIdByName(String name);
	
	Resource findByCode(String code);

}
