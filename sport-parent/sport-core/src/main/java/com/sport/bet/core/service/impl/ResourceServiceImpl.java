package com.sport.bet.core.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sport.bet.bean.model.Resource;
import com.sport.bet.core.mapper.ResourceMapper;
import com.sport.bet.core.service.IResourceService;

@Service
public class ResourceServiceImpl implements IResourceService {

	@Autowired
	private ResourceMapper resourceMapper;
	
	@Override
	public List<Resource> findAll() {
		return resourceMapper.selectAll();
	}
	
	@Override
	public int getIdByName(String name) {
		return resourceMapper.selectIdByName(name);
	}

}
