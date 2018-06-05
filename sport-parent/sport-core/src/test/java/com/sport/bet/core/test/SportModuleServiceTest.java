package com.sport.bet.core.test;

import java.util.ArrayList;
import java.util.List;

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
		List<SportModule> list = new ArrayList<SportModule>();
		SportModule sport = new SportModule();
		sport.setResourceId(1);
		sport.setGroupName("NBA");
		sport.setGameLinesPd("psd");
		list.add(sport);
				
		sportModuleService.saveByBatch(list, "365");
	}
}
