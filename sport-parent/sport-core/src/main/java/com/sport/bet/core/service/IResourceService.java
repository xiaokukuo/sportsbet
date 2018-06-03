package com.sport.bet.core.service;

import java.util.List;

import com.sport.bet.bean.model.Resource;

public interface IResourceService {
	
	/**
	 * 查询全部用户
	 * @return
	 */
	List<Resource> findAll();
	
	
	int getIdByName(String name);

}
