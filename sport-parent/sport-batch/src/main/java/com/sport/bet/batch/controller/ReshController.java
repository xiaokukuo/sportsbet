package com.sport.bet.batch.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sport.bet.bean.model.Resource;
import com.sport.bet.core.service.impl.ResourceServiceImpl;
import com.sport.bet.quartz.job.JobA;

@RestController
@RequestMapping("/refresh/")
public class ReshController {
	
	@Autowired
	private ResourceServiceImpl resourceService;
	
	@RequestMapping("/resource")
	public void resource(){
		Resource resource = resourceService.findById(1, null);
		JobA.setCommonResource(resource);
	}

}
