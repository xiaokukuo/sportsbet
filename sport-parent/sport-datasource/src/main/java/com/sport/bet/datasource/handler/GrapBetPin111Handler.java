package com.sport.bet.datasource.handler;

import java.io.UnsupportedEncodingException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sport.bet.bean.model.SportGameOdds;
import com.sport.bet.bean.model.SportModule;
import com.sport.bet.bean.model.SportModuleGame;
import com.sport.bet.common.utils.HttpTool;
import com.sport.bet.datasource.parsing.pin1111.PageGroupTeamPin111Paser;
import com.sport.bet.datasource.parsing.pin1111.PagePin1111Paser;

@Component
public class GrapBetPin111Handler extends AbstractGrapHandler {

	@Autowired
	private PagePin1111Paser pagePin1111Paser;
	
	@Autowired
	private PageGroupTeamPin111Paser pageGroupTeamPin111Paser;
	 
	//"https://www.pin1111.com/zh-cn/rtn"
	@Override
	public void grabData(int resourceId, String url) throws UnsupportedEncodingException {

		String pageJson = HttpTool.getSportPin111(url);
		
		pagePin1111Paser.setResourceId(resourceId);
		List<SportModule> moduleList = pagePin1111Paser.parsed(pageJson);
		
		if(moduleList != null && moduleList.size() > 0){
			sportModuleService.save(moduleList, "pin111");
		}
		
		List<SportGameOdds> sportGameOddsList = null;
		for (SportModule sportModule : moduleList) {
			pageGroupTeamPin111Paser.setResourceId(resourceId);
			pageJson = HttpTool.getSportPin111(url+sportModule.getGameLinesPd());
			sportGameOddsList = pageGroupTeamPin111Paser.parsed(pageJson);
			
		}
		
		List<SportModuleGame> moduleGameList = pageGroupTeamPin111Paser.getModuleGameList();
		
		if(moduleGameList != null && moduleGameList.size() > 0){
			sportModuleGameService.save(moduleGameList, "pin111");
		}
		
		if(sportGameOddsList != null && sportGameOddsList.size() > 0){
			sportGameOddsService.save(sportGameOddsList, "pin111");
		}
		
	}

}
