package com.sport.bet.core.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.sport.bet.bean.model.SportGameOdds;
import com.sport.bet.core.common.general.GeneralMapper;

@Mapper
public interface SportGameOddsMapper extends GeneralMapper<SportGameOdds> {
	
	List<SportGameOdds> selectJoinGameByEidOrGameId(@Param("gameId") int gameId, @Param("eid") String eid, @Param("tableName") String tableName);

}
