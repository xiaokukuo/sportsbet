package com.sport.bet.datasource.handler;

import java.io.UnsupportedEncodingException;

import org.springframework.beans.factory.annotation.Autowired;

import com.sport.bet.core.service.impl.SportGameOddsServiceImpl;
import com.sport.bet.core.service.impl.SportModuleGameServiceImpl;
import com.sport.bet.core.service.impl.SportModuleServiceImpl;
import com.sport.bet.core.service.impl.TruncateServiceImpl;

public abstract class AbstractGrapHandler {
	
	@Autowired
	protected SportModuleServiceImpl sportModuleService;
	
	@Autowired
	protected SportModuleGameServiceImpl sportModuleGameService;
	
	@Autowired
	protected SportGameOddsServiceImpl sportGameOddsService;
	
	@Autowired
	protected TruncateServiceImpl truncateServiceImpl;
	
	abstract void grabData(int resourceId, String url) throws UnsupportedEncodingException;
}
