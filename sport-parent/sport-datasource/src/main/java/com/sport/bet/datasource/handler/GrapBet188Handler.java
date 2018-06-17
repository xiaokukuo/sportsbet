package com.sport.bet.datasource.handler;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.sport.bet.bean.model.Resource;
import com.sport.bet.bean.model.SportGameOdds;
import com.sport.bet.bean.model.SportModule;
import com.sport.bet.bean.model.SportModuleGame;
import com.sport.bet.common.utils.HttpTool;
import com.sport.bet.core.service.impl.ResourceServiceImpl;
import com.sport.bet.core.service.impl.SportGameOddsServiceImpl;
import com.sport.bet.core.service.impl.SportModuleGameServiceImpl;
import com.sport.bet.core.service.impl.SportModuleServiceImpl;
import com.sport.bet.datasource.parsing.bet188.PageBet188Paser;
import com.sport.bet.datasource.parsing.bet188.PageGroupBet188Paser;
import com.sport.bet.datasource.parsing.bet188.PageGroupTeamBet188Paser;
import com.sport.bet.datasource.utils.ListUtils;
import com.sport.bet.datasource.utils.TableConstant;

@Component
public class GrapBet188Handler {
	
	private Logger logger = LoggerFactory.getLogger(GrapBet188Handler.class);
	
	@Autowired
	private PageBet188Paser pageBet188Paser;
	
	@Autowired
	private PageGroupBet188Paser pageGroupBet188Paser;
	
	@Autowired
	private PageGroupTeamBet188Paser pageGroupTeamBet188Paser;
	
	
	@Autowired
	private ResourceServiceImpl resourceService;
	
	@Autowired
	private SportModuleServiceImpl sportModuleService;
	
	@Autowired
	private SportGameOddsServiceImpl sportGameOddsService;
	
	@Autowired
	private SportModuleGameServiceImpl sportModuleGameService;

	String url = "https://landing-sb.prdasbb18a1.com/zh-cn/Service/CentralService?GetData&ts=1528967723534";
	public void grabGroup(){
		
		Resource resource = resourceService.findByCode("basketball");
		int resourceId = resource.getId();
		
		String pageJosn = HttpTool.getSport188(resource.getUrl());
		
		JSONObject jsonObject = JSONObject.parseObject(pageJosn);
		JSONObject lpd = jsonObject.getJSONObject("lpd");
		
		JSONObject mod = jsonObject.getJSONObject("mod");
		if(mod == null){
			mod = jsonObject.getJSONObject("mbd");
		}
		
		JSONArray psmdArray = lpd.getJSONObject("psm").getJSONArray("psmd");
		
		pageBet188Paser.setResourceId(resourceId);
		List<SportModule> moduleList = pageBet188Paser.parsed(psmdArray.toJSONString());
		
		
		if(ListUtils.isEmpty(moduleList)){
			logger.error("篮球版块数据异常");
			return;
		}
		sportModuleService.save(moduleList, TableConstant.TABALE_NAME_188);
		
		
		/*
		 * 
		 */
		pageGroupBet188Paser.setResourceId(1);
		List<SportModuleGame>  sportModuleGameList = pageGroupBet188Paser.parsed(pageBet188Paser.getNext().toJSONString());
		
		if(ListUtils.isEmpty(sportModuleGameList)){
			logger.error("队伍");
			return;
		}
		sportModuleGameService.save(sportModuleGameList, TableConstant.TABALE_NAME_188);
		
		/*
		 * 
		 */
		JSONArray moddcArray = mod.getJSONObject("d").getJSONArray("c");
		List<SportGameOdds> sportGameOddsList =  pageGroupTeamBet188Paser.parsed(moddcArray.toJSONString());
		if(ListUtils.isEmpty(sportGameOddsList)){
			logger.error("比分异常");
			return;
		}
		sportGameOddsService.save(sportGameOddsList, TableConstant.TABALE_NAME_365);
	}
	
}
