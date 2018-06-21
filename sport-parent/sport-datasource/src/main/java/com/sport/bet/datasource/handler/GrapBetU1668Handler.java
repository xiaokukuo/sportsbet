package com.sport.bet.datasource.handler;

import java.io.UnsupportedEncodingException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.sport.bet.bean.model.SportGameOdds;
import com.sport.bet.common.utils.HttpTool;
import com.sport.bet.datasource.parsing.betu1688.PageU1688Paser;

public class GrapBetU1668Handler extends AbstractGrapHandler {

	@Autowired
	private PageU1688Paser pageU1688Paser;
	
	@Override
	public void grabData(int resourceId, String url) throws UnsupportedEncodingException {
		
		String pageJosnU188 = HttpTool.getSportU16888("http://www.u16888.com/zh-cn/euro/篮球");
		
		List<SportGameOdds> gameOddslist = pageU1688Paser.parsed(pageJosnU188);
		for (SportGameOdds sportGameOdds : gameOddslist) {
			System.out.println(sportGameOdds.toString());
		}
	}
	
}
