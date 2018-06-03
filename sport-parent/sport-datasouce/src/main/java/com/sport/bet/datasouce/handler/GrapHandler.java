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
import com.sport.bet.datasouce.parsing.ParserBet365;
import com.sport.bet.datasouce.service.Bet365Service;

@Component
public class GrapHandler {
	
	@Autowired
	private ParserBet365 parserBet365;
	
	@Autowired
	private Bet365Service bet365Service;
	
	@Autowired
	private ResourceServiceImpl resourceService;
	
	private static String URL = "https://www.365sport365.com/SportsBook.API/web?lid=10&zid=0&cid=42&ctid=42&pd=";
	
	public void grabGpropGame(String pd, int resourceId){
	
		try {
			URL = URL + URLEncoder.encode(pd.substring(3), "UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		List<SportModule> sportGameList = parserBet365.parseSportModule(URL, resourceId);
		
		bet365Service.saveSportGame(sportGameList);
	}
	
	public void grabGroupModule() throws UnsupportedEncodingException{
		List<Resource> listResource = resourceService.findAll();
		Map<String, Integer> map = new HashMap<String, Integer>();
		for (Resource resource : listResource) {
			map.put(resource.getName(), resource.getId());
		}
		
		List<SportMenuDTO> sportMenuList = parserBet365.parseMenu("https://www.365sport365.com/SportsBook.API/web?lid=10&zid=0&pd=%23AL%23&cid=42&ctid=42");
		
		for (SportMenuDTO sport : sportMenuList) {
			if(!map.containsKey(sport.getSportName())){
				continue;
			}
			
			sport.setResourceId(map.get(sport.getSportName()));
			
			List<SportModule> sportModuleList = parserBet365.parseSportModule(getUrl(sport.getSportPd()), sport.getResourceId());
			
			for (SportModule sportModule : sportModuleList) {

				List<SportModuleGame> teamList = parserBet365.parseSportModuleGame(getUrl(sportModule.getGameLinesPd()), 1,sportModule.getGroupName());
				for (SportModuleGame sportModuleGame : teamList) {
					System.err.println(sportModuleGame.toString());
				}
			}
				
		}
	}

	public String getUrl(String pd){
		try {
			return URL+URLEncoder.encode(pd, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return null;
	}
	
}
