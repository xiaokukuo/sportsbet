package com.sport.bet.core.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.sport.bet.bean.model.Sport;

@Mapper
public interface SportMapper {
	
	/** 
	 * 查询全部数据
	 * @return
	 */
	List<Sport> selectAll(@Param("tableName") String tableName);
	
	int insert(Sport sport); 
	
	int selectIdByName(@Param("name")String name, @Param("tableName") String tableName);
	
	String selectPdByResourceId(@Param("resourceId")Integer resourceId, @Param("tableName") String tableName);
	
}
