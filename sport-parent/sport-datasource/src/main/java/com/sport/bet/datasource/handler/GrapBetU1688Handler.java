package com.sport.bet.datasource.handler;

import java.io.UnsupportedEncodingException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sport.bet.bean.model.SportGameOdds;
import com.sport.bet.bean.model.SportModuleGame;
import com.sport.bet.common.utils.HttpTool;
import com.sport.bet.datasource.parsing.betu1688.PageU1688Paser;
import com.sport.bet.datasource.utils.TableConstant;

@Component
public class GrapBetU1688Handler extends AbstractGrapHandler {

	@Autowired
	private PageU1688Paser pageU1688Paser;
	
	@Override
	public void grabData(int resourceId, String url) throws UnsupportedEncodingException {
		truncateServiceImpl.truncateByName(TableConstant.TABALE_NAME_U1688);
		String pageJosnU188 = HttpTool.getSportU16888(url);
		
		pageU1688Paser.setResourceId(resourceId);
		pageU1688Paser.parsed(pageJosnU188);
		
		List<SportModuleGame> moduleGameList = pageU1688Paser.getModuleGameList();
		List<SportGameOdds> gameOddslist = pageU1688Paser.getList();
			
		
		if(moduleGameList != null && moduleGameList.size() > 0){
			sportModuleGameService.save(moduleGameList, TableConstant.TABALE_NAME_U1688);
		}
		if(gameOddslist != null && gameOddslist.size() > 0){
			sportGameOddsService.save(gameOddslist, TableConstant.TABALE_NAME_U1688);
		}
		
		pageU1688Paser.getList().clear();
		pageU1688Paser.getModuleGameList().clear();
		
		
	}
	
}
