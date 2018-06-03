package com.sport.bet.core.test;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.sport.bet.bean.model.SportModule;
import com.sport.bet.core.service.impl.SportModuleServiceImpl;
import com.sport.bet.core.test.base.BaseTest;

public class SportModuleServiceTest extends BaseTest {

	@Autowired
	private SportModuleServiceImpl sportModuleService;
	
	@Test
	//@Rollback(value = true)
	public void insertTest (){
		
		SportModule sport = new SportModule();
		sport.setResourceId(1);
		sport.setGroupName("NBA");
		sport.setGameLinesPd("psd");
				
		sportModuleService.save(sport,"365");
	}
}
