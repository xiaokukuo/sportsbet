package com.sport.bet.core.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.sport.bet.bean.model.SportModuleGame;

@Mapper
public interface SportModuleGameMapper {

	int insert(@Param("sportGame")SportModuleGame sprotGame, @Param("tbName") String tbName);
	
}
