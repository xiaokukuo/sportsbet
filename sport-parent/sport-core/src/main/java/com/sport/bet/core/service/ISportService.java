package com.sport.bet.core.service;

import java.util.List;

import com.sport.bet.bean.model.Sport;

public interface ISportService {

	/** 
	 * 查询全部数据
	 * @return
	 */
	List<Sport> findAll(String tableName);
	
	int insert(Sport sport); 
	
	int findIdByName(String name, String tableName);
	
	String findPdByResourceId(Integer reousrceId, String tableName);
	
}
