package com.sport.bet.core.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sport.bet.bean.model.Resource;
import com.sport.bet.core.common.general.GeneralMapper;
import com.sport.bet.core.common.general.GeneralServiceImpl;
import com.sport.bet.core.mapper.ResourceMapper;
import com.sport.bet.core.service.IResourceService;

@Service
public class ResourceServiceImpl extends GeneralServiceImpl<Resource> implements IResourceService {

	@Autowired
	private ResourceMapper resourceMapper;
	
	
	@Override
	public GeneralMapper<Resource> getGeneralMapper() {
		return resourceMapper;
	}
	
	@Override
	public int getIdByName(String name) {
		return resourceMapper.selectIdByName(name);
	}
	

}
