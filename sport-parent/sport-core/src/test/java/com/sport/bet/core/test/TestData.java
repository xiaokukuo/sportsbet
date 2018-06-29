package com.sport.bet.core.test;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.sport.bet.bean.model.po.GameInfo;
import com.sport.bet.core.mapper.GameInfoMapper;
import com.sport.bet.core.test.base.BaseTest;

public class TestData extends BaseTest {
	DecimalFormat df = new DecimalFormat("#0.0");  
	@Autowired
	private GameInfoMapper gameInfoMapper;
	
	@Test
	public void testMap (){
		
		List<GameInfo> team188List = gameInfoMapper.selectByEid(1,"188");
		List<GameInfo> teamU1688List = gameInfoMapper.selectByEid(1,"u1688");//正好不带
		
		
		HashMap<String, GameInfo> map188 = new HashMap<>();
		HashMap<String, GameInfo> mapU1688 = new HashMap<>();
		
		String teamNA = null;
		for (GameInfo gameInfo : team188List) {
			map188.put(gameInfo.getTeamName1()+gameInfo.getTeamNa(), gameInfo);
		}
		
		
		
		for (GameInfo gameInfo : teamU1688List) {
			mapU1688.put(gameInfo.getTeamName1()+gameInfo.getTeamNa().substring(0, gameInfo.getTeamNa().length()-1), gameInfo);
		}
		
		for (String key : mapU1688.keySet()) {
		      System.out.println(key);
		}
		
		for (String key : map188.keySet()) {
		      System.err.println(key);
		}
	}
	
}
