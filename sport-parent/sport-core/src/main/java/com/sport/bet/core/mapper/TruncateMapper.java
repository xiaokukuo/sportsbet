package com.sport.bet.core.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface TruncateMapper {

	void truncateModule(@Param("tableName") String tableName);
	
	void truncateModuleGame(@Param("tableName") String tableName);
	
	void truncateGameOdds(@Param("tableName") String tableName);
	
}
