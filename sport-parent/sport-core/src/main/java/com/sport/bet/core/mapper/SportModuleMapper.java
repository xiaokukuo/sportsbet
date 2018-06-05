package com.sport.bet.core.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.sport.bet.bean.model.SportModule;

@Mapper
public interface SportModuleMapper {

	int insert(@Param("sportModule") SportModule sportModule, @Param("tableName") String tableName); 
	
	int insertByBatch(@Param("list") List<SportModule> sportModuleList, @Param("tableName") String tableName); 
	
}
