package com.sport.bet.datasource.handler;

import java.io.UnsupportedEncodingException;

import org.springframework.beans.factory.annotation.Autowired;

import com.sport.bet.core.service.impl.SportGameOddsServiceImpl;

public abstract class AbstractGrapHandler {
	
	@Autowired
	protected SportGameOddsServiceImpl sportGameOddsService;

	abstract void grabData(int resourceId, String url) throws UnsupportedEncodingException;
}
