package com.sport.bet.core.test;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.sport.bet.bean.model.Resource;
import com.sport.bet.core.service.impl.ResourceServiceImpl;
import com.sport.bet.core.test.base.BaseTest;

public class ResourceServiceImplTest extends BaseTest {

	@Autowired
	private ResourceServiceImpl resourceService;
	
	@Test
	public void findAllTest (){
		List<Resource> resourceList = resourceService.findAll(null);
		
		for (Resource resource : resourceList) {
			System.out.println(resource.toString());
		}
		
	}
	
	@Test
	public void getIdByNameTest (){
		int id = resourceService.getIdByName("篮球");
		
		System.out.println(id);
	}
	
	@Test
	public void saveResource (){
	
		Resource re = new Resource();
		re.setCode("football");
		re.setName("足球");
		re.setUrl188("https");
		re.setUrl365("https");
		re.setUrlpin111("https://www.pin1111.com/en/rtn");
		re.setUrlu1688("https");
		
		resourceService.save(re, null);
		
	}
	
}
