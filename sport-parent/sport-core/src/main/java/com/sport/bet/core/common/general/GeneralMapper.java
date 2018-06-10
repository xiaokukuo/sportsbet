package com.sport.bet.core.common.general;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface GeneralMapper<T>{
	 
	T selectById(@Param("id") int id, @Param("tableName") String tableName);
	
	List<T> selectAll(@Param("tableName") String tableName);
	
	int insert(@Param("entity")T entity, @Param("tableName") String tableName);
	
	int insertByBatch(@Param("list") List<T> list, @Param("tableName") String tableName); 
	
	int truncateTable(@Param("tableName") String tableName);

}
