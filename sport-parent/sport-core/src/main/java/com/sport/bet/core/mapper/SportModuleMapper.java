package com.sport.bet.core.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.sport.bet.bean.model.SportModule;

@Mapper
public interface SportModuleMapper {

	int insert(@Param("sportModule") SportModule sportModule, @Param("tableName") String tableName); 
	
}
