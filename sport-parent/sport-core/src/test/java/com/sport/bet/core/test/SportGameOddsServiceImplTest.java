package com.sport.bet.core.test;

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
}
