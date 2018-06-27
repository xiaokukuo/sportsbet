package com.sport.bet.datasource.handler;

import java.io.UnsupportedEncodingException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sport.bet.bean.model.SportGameOdds;
import com.sport.bet.bean.model.SportModule;
import com.sport.bet.bean.model.SportModuleGame;
import com.sport.bet.common.utils.HttpTool;
import com.sport.bet.datasource.enums.EnumSportType;
import com.sport.bet.datasource.parsing.pin1111.PageGroupTeamPin111Paser;
import com.sport.bet.datasource.parsing.pin1111.PagePin1111Paser;
import com.sport.bet.datasource.utils.TableConstant;

@Component
public class GrapBetPin111Handler extends AbstractGrapHandler {

	@Autowired
	private PagePin1111Paser pagePin1111Paser;
	
	@Autowired
	private PageGroupTeamPin111Paser pageGroupTeamPin111Paser;
	 
	//"https://www.pin1111.com/zh-cn/rtn"
	@Override
	public void grabData(int resourceId, String url) throws UnsupportedEncodingException {
		truncateServiceImpl.truncateByName(TableConstant.TABALE_NAME_PIN1111);
		String pageJson = HttpTool.getSportPin111(url+"/zh-cn/rtn");
		
		pagePin1111Paser.setResourceId(resourceId);
		pagePin1111Paser.setSportType(EnumSportType.ESPORTS.getcode());
		List<SportModule> moduleList = pagePin1111Paser.parsed(pageJson);
		
		if(moduleList == null || moduleList.size() <= 0){
			System.err.println("moduleList空");
			return;
		}
		
		sportModuleService.save(moduleList, TableConstant.TABALE_NAME_PIN1111);
		
		List<SportGameOdds> sportGameOddsList = null;
		for (SportModule sportModule : moduleList) {
			pageGroupTeamPin111Paser.setResourceId(resourceId);
			pageGroupTeamPin111Paser.setModuleId(sportModule.getId());
			pageJson = HttpTool.getSportPin111(url+sportModule.getGameLinesPd());
			sportGameOddsList = pageGroupTeamPin111Paser.parsed(pageJson);
		}
		
		if(sportGameOddsList == null || sportGameOddsList.size() <= 0){
			System.err.println("pageGroupTeamData:"+pageJson);
			return;
		}
		
		List<SportModuleGame> moduleGameList = pageGroupTeamPin111Paser.getModuleGameList();
		
		if(moduleGameList != null && moduleGameList.size() > 0){
			sportModuleGameService.save(moduleGameList,TableConstant.TABALE_NAME_PIN1111);
		}
		
		sportGameOddsService.save(sportGameOddsList, TableConstant.TABALE_NAME_PIN1111);
		
	}

}
