package com.sport.bet.core.test;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.sport.bet.bean.model.SportGameOdds;
import com.sport.bet.core.service.impl.SportGameOddsServiceImpl;
import com.sport.bet.core.test.base.BaseTest;

public class SportGameOddsServiceImplTest  extends BaseTest {

	@Autowired
	private SportGameOddsServiceImpl sportGameOddsService;
	
	@Test
	public void insertTest (){
		List<SportGameOdds> list = new ArrayList<SportGameOdds>();
		SportGameOdds sport = new SportGameOdds();
		sport.setGameId(1);
		sport.setScoreType(1);
		sport.setScore("178.5");
		sport.setHigher("3/5");
		sport.setLower("5/7");
		list.add(sport);
				
		sportGameOddsService.save(list, "365");
	}
	
	@Test
	public void findTest (){
		List<SportGameOdds> list = sportGameOddsService.listJoinGameByEid(0, "2634265", "188");
		
		List<SportGameOdds> list2 = sportGameOddsService.listJoinGameByEid(1, null, "365");
		
		for (SportGameOdds odds : list) {
			if(odds.getScoreType() == 1){
				for (SportGameOdds odds2 : list2) {
					if(odds2.getScoreType() == 2){
						if(paserDouble(odds2.getTeamNa())+paserDouble(odds.getTeamNa()) <0.00001
								&& paserDouble(odds2.getTeamNa())+paserDouble(odds.getTeamNa()) > -0.00001){
							//System.out.println(odds.getTeamNa() +": "+odds.getTeamScore() +"  ---"+odds2.getTeamNa() +": "+odds2.getTeamScore() );
							Double d1 = Double.parseDouble(odds.getTeamScore()); 
							String[] odd2Arr = odds2.getTeamScore().split("\\/");
							Double d2 = Double.parseDouble(odd2Arr[0])/Double.valueOf(odd2Arr[1]);
				            calculation(d1,d2);
							
						}
						
					}
				}
				
				
			}
			
		}
		
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
		System.out.println(df.format(sheng) +  "==="+df.format(fu));
		
		return 0d;
	}
	
	public static void main(String[] args) {
		calculation(2.6,2.87);
	}
	
}
