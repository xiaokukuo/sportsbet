package com.sport.bet.web.test.controller;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.sport.bet.bean.model.Resource;
import com.sport.bet.core.service.impl.ResourceServiceImpl;
import com.sport.bet.web.test.base.BaseTest;

public class ResourceServiceImplTest extends BaseTest {

	@Autowired
	private ResourceServiceImpl resourceService;
	
	@Test
	public void findAllTest (){
		List<Resource> resourceList = resourceService.findAll();
		
		System.out.println(resourceList.get(0).getId());
	}
	
}
