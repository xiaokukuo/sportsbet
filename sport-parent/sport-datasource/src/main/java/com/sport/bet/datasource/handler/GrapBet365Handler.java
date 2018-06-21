package com.sport.bet.datasource.handler;

import java.io.UnsupportedEncodingException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sport.bet.bean.model.SportGameOdds;
import com.sport.bet.bean.model.SportModule;
import com.sport.bet.bean.model.SportModuleGame;
import com.sport.bet.common.utils.HttpTool;
import com.sport.bet.core.service.impl.SportGameOddsServiceImpl;
import com.sport.bet.core.service.impl.SportModuleGameServiceImpl;
import com.sport.bet.core.service.impl.SportModuleServiceImpl;
import com.sport.bet.datasource.parsing.bet365.PageGroupPaser;
import com.sport.bet.datasource.parsing.bet365.PageGroupTeamPaser;
import com.sport.bet.datasource.parsing.bet365.PagePaser;
import com.sport.bet.datasource.utils.HttpUtils;
import com.sport.bet.datasource.utils.ListUtils;
import com.sport.bet.datasource.utils.TableConstant;

@Component
public class GrapBet365Handler extends AbstractGrapHandler{
	
	private Logger logger = LoggerFactory.getLogger(GrapBet365Handler.class);
	
	@Autowired
	private PagePaser pagePaser;
	
	@Autowired
	private PageGroupPaser pageGroupPaser;
	
	@Autowired
	private PageGroupTeamPaser pageGroupTeamPaser;
	
	@Autowired
	private SportModuleServiceImpl sportModuleService;
	
	@Autowired
	private SportModuleGameServiceImpl sportModuleGameService;
	
	@Autowired
	private SportGameOddsServiceImpl sportGameOddsService;
	
	//private static String URL = "https://www.365sport365.com/SportsBook.API/web?lid=10&zid=0&cid=42&ctid=42&pd=";
	@Override
	public void grabData(int resourceId, String url) throws UnsupportedEncodingException{
		
		//1、获取篮球页面的数据--group
		String pageStr = HttpTool.getSport365(url);
		
		List<SportModule> sportModule188List = sportModuleService.findAll(TableConstant.TABALE_NAME_188);
		pagePaser.setSportModule188List(sportModule188List);
		pagePaser.setResourceId(resourceId);
		List<SportModule> sportModuleList = pagePaser.parsed(pageStr);
		
		if(ListUtils.isEmpty(sportModuleList)){
			logger.error("篮球版块数据异常");
			return;
		}
		
		sportModuleList = sportModuleService.save(sportModuleList, TableConstant.TABALE_NAME_365);
		
		//2、遍历每个篮球模块，获取对应模块的比赛队伍
		List<SportModuleGame> teamList = null;
		for (SportModule sportModule : sportModuleList) {
			String gameLineUrl = HttpUtils.getUrl356(sportModule.getGameLinesPd());
			String responseStr = HttpTool.getSport365(gameLineUrl);
			//解析比赛队伍
			pageGroupPaser.setModuleId(sportModule.getId());
			pageGroupPaser.setResourceId(resourceId);
			teamList = pageGroupPaser.parsed(responseStr);
			
			/*if(ListUtils.isEmpty(teamList)){
				logger.error("{}——篮球版块的没有比赛",sportModule.getGroupName());
				continue;
			}*/
			
		}
		teamList = sportModuleGameService.save(teamList, TableConstant.TABALE_NAME_365);
		logger.info("end");
		
		//3、遍历比赛队伍，获取比赛队伍的信息
		List<SportGameOdds>  gameOddsList = null;
		for (SportModuleGame sportModuleGame : teamList) {
			String urlscore = HttpUtils.getUrl356(sportModuleGame.getDeailPd());
			String pageScoreResponse = HttpTool.getSport365(urlscore);
			
			pageGroupTeamPaser.setGameId(sportModuleGame.getId());
			//解析比赛分数
			gameOddsList = pageGroupTeamPaser.parsed(pageScoreResponse);
			if(ListUtils.isEmpty(teamList)){
				logger.error("{}——队伍分数数据发生异常",sportModuleGame.getTeamName1()+" V "+sportModuleGame.getTeamName2());
				return;
			}
		}
		sportGameOddsService.save(gameOddsList, TableConstant.TABALE_NAME_365);
				
	}

}
