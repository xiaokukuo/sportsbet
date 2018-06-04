package com.sport.bet.core.test;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.sport.bet.bean.model.SportModuleGame;
import com.sport.bet.core.service.impl.SportModuleGameServiceImpl;
import com.sport.bet.core.test.base.BaseTest;

public class SportModuleGameImpl extends BaseTest {

	@Autowired
	private SportModuleGameServiceImpl sportModuleGameService;
	
	@Test
	//@Rollback(value = true)
	public void insertTest (){
		//List<SportModule> list = new ArrayList<SportModule>();
		SportModuleGame sport = new SportModuleGame();
		sport.setResourceId(1);
		sport.setSportGroupId(1);
		sport.setDeailPd("123");
		sport.setTeamName1("team1");
		sport.setTeamName2("Team2");
		sport.setGameTime("123123");
		//list.add(sport);
				
		sportModuleGameService.save(sport, "365");
	}
	
}
