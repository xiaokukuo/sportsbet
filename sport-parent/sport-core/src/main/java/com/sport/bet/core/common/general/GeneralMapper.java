package com.sport.bet.core.common.general;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface GeneralMapper<T>{
	
	int insertByBatch(@Param("list") List<T> list, @Param("tableName") String tableName); 

}
