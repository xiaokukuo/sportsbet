package com.sport.bet.datasouce.handler;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sport.bet.bean.dto.SportMenuDTO;
import com.sport.bet.bean.model.Resource;
import com.sport.bet.bean.model.SportModule;
import com.sport.bet.bean.model.SportModuleGame;
import com.sport.bet.core.service.impl.ResourceServiceImpl;
import com.sport.bet.core.service.impl.SportModuleGameServiceImpl;
import com.sport.bet.core.service.impl.SportModuleServiceImpl;
import com.sport.bet.datasouce.parsing.ParserBet365;
import com.sport.bet.datasouce.service.Bet365Service;

@Component
public class GrapHandler {
	
	@Autowired
	private ParserBet365 parserBet365;
	
	@Autowired
	private Bet365Service bet365Service;
	
	@Autowired
	private SportModuleServiceImpl sportModuleService;
	
	@Autowired
	private ResourceServiceImpl resourceService;
	
	@Autowired
	private SportModuleGameServiceImpl sportModuleGameService;
	
	private static String URL = "https://www.365sport365.com/SportsBook.API/web?lid=10&zid=0&cid=42&ctid=42&pd=";
	
	private static String TABALE_NAME_365 = "365";
	
	public void grabGroupModule() throws UnsupportedEncodingException{
		List<Resource> listResource = resourceService.findAll();
		Map<String, Integer> map = new HashMap<String, Integer>();
		for (Resource resource : listResource) {
			map.put(resource.getName(), resource.getId());
		}
		
		//1、 获取网页菜单（）
		List<SportMenuDTO> sportMenuList = parserBet365.parseMenu("https://www.365sport365.com/SportsBook.API/web?lid=10&zid=0&pd=%23AL%23&cid=42&ctid=42");
		
		int resourceId = 0;
		int moduleId = 0;
		
		for (SportMenuDTO sport : sportMenuList) {
			if(!map.containsKey(sport.getSportName())){
				continue;
			}
			
			sport.setResourceId(map.get(sport.getSportName()));
			resourceId = sport.getResourceId();
			
			//2、 获取每个菜单对应的界面，及元素
			List<SportModule> sportModuleList = parserBet365.parseSportModule(getUrl(sport.getSportPd()), resourceId);
			
			for (SportModule sportModule : sportModuleList) {
				
				//保存sortModule
				moduleId = sportModuleService.save(sportModule, TABALE_NAME_365);
				
				//3、获取比赛队伍
				List<SportModuleGame> teamList = parserBet365.parseSportModuleGame(getUrl(sportModule.getGameLinesPd()),resourceId, moduleId);
				
				// 批量保存SportMoudleGame
				if(teamList != null && teamList.size() > 0){
					sportModuleGameService.saveByBatch(teamList, TABALE_NAME_365);
				}
				
			}
				
		}
	}

	public void grabScore(String pd){
		parserBet365.parseSportGameScore(getUrl(pd), 1, 1);
	}
	
	public static String getUrl(String pd){
		try {
			return URL+URLEncoder.encode(pd, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static void main(String[] args) {
		String Pd = "#AC#B18#C20448857#D19#E5760231#F19#G180114#H4#M74340490#O3#S^1#";
		
		System.out.println(getUrl(Pd));
		
		//https://www.365sport365.com/SportsBook.API/web?lid=10&zid=0&cid=42&ctid=42&pd=%23AC%23B18%23C20448857%23D19%23E5760231%23F19%23G180114%23H4%23M74340490%23O3%23S%5E1%23
		//https://www.365sport365.com/SportsBook.API/web?lid=10&zid=0&cid=42&ctid=42&pd=%23AC%23B18%23C20448857%23D19%23E5760231%23F19%23G180114%23H4%23M74340490%23O3%23S%5E1
	}
}
