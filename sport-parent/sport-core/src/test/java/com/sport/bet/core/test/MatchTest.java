package com.sport.bet.core.test;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.sport.bet.bean.model.po.GameInfo;
import com.sport.bet.core.mapper.GameInfoMapper;
import com.sport.bet.core.po.ViewBean;
import com.sport.bet.core.test.base.BaseTest;

public class MatchTest extends BaseTest  {
	
	@Autowired
	private GameInfoMapper gameInfoMapper;
	
	@Test
	public void matchGameTest (){
		
		List<GameInfo> team365List = gameInfoMapper.selectByGameId(1,"365");
		List<GameInfo> team188List = gameInfoMapper.selectByEid(1,"188");
		List<GameInfo> teamPinList = gameInfoMapper.selectByEid(1,"pin111");//正好不带
		List<GameInfo> teamU1688List = gameInfoMapper.selectByEid(1,"u1688");//正好不带
		
		
		HashMap<String, GameInfo> map188 = new HashMap<>();
		HashMap<String, GameInfo> mapPin111 = new HashMap<>();
		HashMap<String, GameInfo> mapU1688 = new HashMap<>();
		
		String teamNA = null;
		for (GameInfo gameInfo : team188List) {
			map188.put(gameInfo.getTeamName1()+gameInfo.getTeamNa(), gameInfo);
		}
		
		for (GameInfo gameInfo : teamPinList) {
			mapPin111.put(gameInfo.getTeamName1()+gameInfo.getTeamNa(), gameInfo);
		}
		
		for (GameInfo gameInfo : teamU1688List) {
			mapU1688.put(gameInfo.getTeamName1()+gameInfo.getTeamNa().substring(0, gameInfo.getTeamNa().length()-1), gameInfo);
		}
		
		
		GameInfo oddspin111 = null;
		GameInfo oddsu1688 = null;
		String key1 = null;
		String key2 = null;
		
		List<ViewBean> viewList = new ArrayList<>();
		
		for (GameInfo odds188 : team188List) {
			teamNA = odds188.getTeamNa();
			if(teamNA.startsWith("-")){
				teamNA = teamNA.substring(1);
			}else{
				teamNA = "-"+teamNA;
			}
			key1 = odds188.getTeamName1()+teamNA;
			key2 = odds188.getTeamName2()+teamNA;
			
			System.out.println(key1+"---"+key2);
			
			if(mapPin111 != null && mapPin111.size()>0 && (mapPin111.containsKey(key1) || mapPin111.containsKey(key2))){
				GameInfo oddspin11 = mapPin111.get(key1);
				if(oddspin11 == null){
					oddspin11 = mapPin111.get(key2);
				}
				double a = calculation(Double.parseDouble(odds188.getTeamScore()), Double.parseDouble(oddspin11.getTeamScore()));
				System.err.println(a);
			}
			
			if(mapU1688 != null && mapU1688.size()>0 && (mapU1688.containsKey(key1) || mapU1688.containsKey(key2))){
				GameInfo oddsU1688 = mapU1688.get(key1);
				if(oddsU1688 == null){
					oddsU1688 = mapU1688.get(key2);
				}
				double a = calculation(Double.parseDouble(odds188.getTeamScore()), Double.parseDouble(oddsU1688.getTeamScore()));
				System.err.println(a);
			}
		}
		
		for (GameInfo oddsPin111 : teamPinList) {
			teamNA = oddsPin111.getTeamNa();
			if(teamNA.startsWith("-")){
				teamNA = teamNA.substring(1);
			}else{
				teamNA = "-"+teamNA;
			}
			key1 = oddsPin111.getTeamName1()+teamNA;
			key2 = oddsPin111.getTeamName2()+teamNA;
			
			
			if(mapU1688 != null && mapU1688.size()>0 && (mapU1688.containsKey(key1) || mapU1688.containsKey(key2))){
				GameInfo oddsU1688 = mapU1688.get(key1);
				if(oddsU1688 == null){
					oddsU1688 = mapU1688.get(key2);
				}
				double a = calculation(Double.parseDouble(oddsPin111.getTeamScore()), Double.parseDouble(oddsU1688.getTeamScore()));
				System.err.println(a);
			}
		}
		
		for (GameInfo odds365 : team365List) {
			teamNA = odds365.getTeamNa();
			if(teamNA.startsWith("-")){
				teamNA = teamNA.substring(1);
			}else{
				teamNA = "-"+teamNA.substring(1);
			}
			key1 = odds365.getTeamName1()+teamNA;
			key2 = odds365.getTeamName2()+teamNA;
			
			double teamScore365 = getTeamScore365(odds365.getTeamScore());
			
			if(map188 != null && map188.size()>0 && (map188.containsKey(key1) || map188.containsKey(key2))){
				GameInfo odds188 = map188.get(key1);
				if(odds188 == null){
					odds188 = map188.get(key2);
				}
				
				double a = calculation(teamScore365, Double.parseDouble(odds188.getTeamScore()));
				System.out.println(a);
			}
			//
			if(mapPin111 != null && mapPin111.size()>0 && (mapPin111.containsKey(key1) || mapPin111.containsKey(key2))){
				
				oddspin111 = mapPin111.get(key1);
				if(oddspin111 == null){
					oddspin111 = mapPin111.get(key2);
				}
				double a = calculation(teamScore365, Double.parseDouble(oddspin111.getTeamScore()));
				System.out.println(a);
			}
			//
			if(mapU1688 != null && mapU1688.size()>0 && (mapU1688.containsKey(key1) || mapU1688.containsKey(key2))){
				oddsu1688 = mapU1688.get(key1);
				if(oddsu1688 == null){
					oddsu1688 = mapU1688.get(key2);
				}
				double a = calculation(teamScore365, Double.parseDouble(oddsu1688.getTeamScore()));
				System.out.println(a);
			}
		}
		
	}
	
	public static Double getTeamScore365(String teamScore){
		String[] arr = teamScore.split("\\/");
		return Double.parseDouble(arr[0])/Double.parseDouble(arr[1]);
	}
	
	public static Double paserDouble(String str){
		if(str.startsWith("+")){
			return Double.parseDouble(str.substring(1));
		}
		if(str.startsWith("-")){
			return 0-Double.parseDouble(str.substring(1));
		}
		
		return 0d;
		
	}
	
	public static Double calculation(Double d1, Double d2){
		Double sum = d1+d2;
		Double sheng = (1 - d1/sum)*d1-1;
		
		Double fu = (1 - d2/sum)*d2-1;
		
		DecimalFormat df = new DecimalFormat("#0.0000");  
		
		if(df.format(sheng).equals(df.format(fu))){
			return Double.parseDouble(df.format(sheng));
		}
		
		return 0d;
	}
	
}
