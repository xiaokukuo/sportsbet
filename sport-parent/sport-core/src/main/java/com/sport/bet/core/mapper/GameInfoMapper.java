package com.sport.bet.core.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.sport.bet.bean.model.po.GameInfo;

@Mapper
public interface GameInfoMapper {
	
	List<GameInfo> selectByEid(@Param("scoreType")int scoreType, @Param("tableName") String tableName);
	
	List<GameInfo> selectByGameId(@Param("scoreType")int scoreType, @Param("tableName") String tableName);

}
