package com.sport.bet.core.test;

import java.util.ArrayList;
import java.util.List;

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
		List<SportModuleGame> list = new ArrayList<SportModuleGame>();
		SportModuleGame sport = new SportModuleGame();
		sport.setResourceId(1);
		sport.setSportGroupId(1);
		sport.setDeailPd("123");
		sport.setTeamName1("team1");
		sport.setTeamName2("Team2");
		sport.setGameTime("123123");
		
		SportModuleGame sport1 = new SportModuleGame();
		sport1.setResourceId(2);
		sport1.setSportGroupId(2);
		sport1.setDeailPd("22222");
		sport1.setTeamName1("team2");
		sport1.setTeamName2("Team4");
		sport1.setGameTime("2222");
		
		list.add(sport);
		list.add(sport1);
				
		//sportModuleGameService.saveByBatch(list, "365");
	}
	
}
