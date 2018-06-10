package com.sport.bet.core.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.sport.bet.bean.model.Resource;
import com.sport.bet.core.common.general.GeneralMapper;

@Mapper
public interface ResourceMapper extends GeneralMapper<Resource> {

	int selectIdByName(String name);
	
}
