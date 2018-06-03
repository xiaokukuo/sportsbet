package com.sport.bet.core.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.sport.bet.bean.model.Resource;

@Mapper
public interface ResourceMapper {

	/**
	 * 查询全部数据
	 * 
	 * @return
	 */
	List<Resource> selectAll();
	
	
	int selectIdByName(String name);
	
}
