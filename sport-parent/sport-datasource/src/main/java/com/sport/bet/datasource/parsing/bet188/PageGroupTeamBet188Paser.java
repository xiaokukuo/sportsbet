package com.sport.bet.datasource.parsing.bet188;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sport.bet.bean.model.SportGameOdds;
import com.sport.bet.datasource.parsing.AbstractPaser;
import com.sport.bet.datasource.parsing.bet365.PageGroupTeamPaser;

public class PageGroupTeamBet188Paser extends AbstractPaser<SportGameOdds> {

	Logger logger = LoggerFactory.getLogger(PageGroupTeamPaser.class);

	private volatile int gameId;
	
	@Override
	public List<SportGameOdds> parsed(String pageJson) {
		return null;
	}

}
