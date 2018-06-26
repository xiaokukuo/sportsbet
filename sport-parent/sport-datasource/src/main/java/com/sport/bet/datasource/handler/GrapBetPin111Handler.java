package com.sport.bet.datasource.handler;

import java.io.UnsupportedEncodingException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.sport.bet.bean.model.SportModule;
import com.sport.bet.common.utils.HttpTool;
import com.sport.bet.core.service.impl.SportModuleServiceImpl;
import com.sport.bet.datasource.parsing.pin1111.PagePin1111Paser;

public class GrapBetPin111Handler extends AbstractGrapHandler {

	@Autowired
	private PagePin1111Paser pagePin1111Paser;
	
	@Autowired
	private SportModuleServiceImpl sportModuleService;
	
	//"https://www.pin1111.com/zh-cn/rtn"
	@Override
	void grabData(int resourceId, String url) throws UnsupportedEncodingException {

		String pageJosn = HttpTool.getSportPin111(url);
		
		pagePin1111Paser.setResourceId(resourceId);
		List<SportModule> moduleList = pagePin1111Paser.parsed(pageJosn);
		
		if(moduleList != null && moduleList.size() < 0){
			sportModuleService.save(moduleList, "pin111");
		}
		
	}

}
