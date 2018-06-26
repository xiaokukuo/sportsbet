package com.sport.bet.datasource.handler;

import java.io.UnsupportedEncodingException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.sport.bet.bean.model.SportGameOdds;
import com.sport.bet.common.utils.HttpTool;
import com.sport.bet.datasource.parsing.betu1688.PageU1688Paser;

public class GrapBetU1688Handler extends AbstractGrapHandler {

	@Autowired
	private PageU1688Paser pageU1688Paser;
	
	
	//"http://www.u16888.com/zh-cn/euro/篮球"
	@Override
	public void grabData(int resourceId, String url) throws UnsupportedEncodingException {
		
		String pageJosnU188 = HttpTool.getSportU16888(url);
		
		pageU1688Paser.setResourceId(resourceId);
		List<SportGameOdds> gameOddslist = pageU1688Paser.parsed(pageJosnU188);
		if(gameOddslist != null && gameOddslist.size() < 0){
			sportGameOddsService.save(gameOddslist, "U1688");
		}
		
	}
	
}
