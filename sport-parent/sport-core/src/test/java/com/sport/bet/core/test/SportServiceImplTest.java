package com.sport.bet.core.test;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import com.sport.bet.bean.model.Sport;
import com.sport.bet.core.service.impl.SportServiceImpl;
import com.sport.bet.core.test.base.BaseTest;

public class SportServiceImplTest extends BaseTest  {

	@Autowired
	private SportServiceImpl sportService;
	
	@Test
	public void findAllTest (){
		List<Sport> resourceList = sportService.findAll("365");
		
		System.out.println(resourceList);
	}
	
	@Test
	public void findPdTest (){
		String pd =sportService.findPdByResourceId(1, "365");
		System.out.println(pd);
	}
	
	@Test
	@Transactional()
	@Rollback(value = true)
	public void insertTest (){
		
		Sport sport = new Sport();
		sport.setName("123");
		sport.setResourceId(1);
		sport.setTableName("365");
				
		sportService.insert(sport);
	}
	
}
