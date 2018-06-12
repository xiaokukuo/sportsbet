package com.sport.bet.datasource.handler;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sport.bet.bean.model.Resource;
import com.sport.bet.bean.model.SportGameOdds;
import com.sport.bet.bean.model.SportModule;
import com.sport.bet.bean.model.SportModuleGame;
import com.sport.bet.common.utils.HttpTool;
import com.sport.bet.core.service.impl.ResourceServiceImpl;
import com.sport.bet.core.service.impl.SportGameOddsServiceImpl;
import com.sport.bet.core.service.impl.SportModuleGameServiceImpl;
import com.sport.bet.core.service.impl.SportModuleServiceImpl;
import com.sport.bet.datasource.parsing.bet365.PageGroupPaser;
import com.sport.bet.datasource.parsing.bet365.PageGroupTeamPaser;
import com.sport.bet.datasource.parsing.bet365.PagePaser;

@Component
public class GrapBet365Handler {
	
	@Autowired
	private PagePaser pagePaser;
	
	@Autowired
	private PageGroupPaser pageGroupPaser;
	
	@Autowired
	private PageGroupTeamPaser pageGroupTeamPaser;
	
	@Autowired
	private ResourceServiceImpl resourceService;
	
	@Autowired
	private SportModuleServiceImpl sportModuleService;
	
	@Autowired
	private SportGameOddsServiceImpl sportGameOddsService;
	
	@Autowired
	private SportModuleGameServiceImpl sportModuleGameService;
	
	private static String URL = "https://www.365sport365.com/SportsBook.API/web?lid=10&zid=0&cid=42&ctid=42&pd=";
	
	private static String TABALE_NAME_365 = "365";
	
	public void grabGroupModule() throws UnsupportedEncodingException{
		
		//List<Resource> listResource = resourceService.findAll(null);
		
		Resource resource = resourceService.findByCode("basketball");
		String pageStr = HttpTool.getSport365(resource.getUrl());
		
		//获取篮球页面的数据--group
		List<SportModule> sportModuleList = pagePaser.parsed(pageStr);
		sportModuleList = sportModuleService.save(sportModuleList, TABALE_NAME_365);
		
		List<SportModuleGame> teamList = null;
		//遍历每个篮球模块，获取对应模块的比赛队伍
		for (SportModule sportModule : sportModuleList) {
			String url =getUrl(sportModule.getGameLinesPd());
			String responseStr = HttpTool.getSport365(url);
		
			//解析比赛队伍
			teamList = pageGroupPaser.parsed(responseStr);
			if(teamList != null && teamList.size() > 0){
				teamList = sportModuleGameService.save(teamList, TABALE_NAME_365);
			}
		}
		
		//遍历比赛队伍，获取比赛队伍的信息
		for (SportModuleGame sportModuleGame : teamList) {
			
			String urlscore = getUrl(sportModuleGame.getDeailPd());
			String pageScoreResponse = HttpTool.getSport365(urlscore);
			
			//解析比赛分数
			List<SportGameOdds>  list = pageGroupTeamPaser.parsed(pageScoreResponse);
			if(list != null && list.size() > 0){
				sportGameOddsService.save(list, TABALE_NAME_365);
			}
		}
				
	}
	
	public static String getUrl(String pd){
		try {
			return URL+URLEncoder.encode(pd, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return null;
	}
	

}
