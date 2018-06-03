package com.sport.bet.datasouce.handler;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sport.bet.bean.model.SportModule;
import com.sport.bet.datasouce.parsing.ParserBet365;
import com.sport.bet.datasouce.service.Bet365Service;

@Component
public class GrapHandler {
	
	@Autowired
	private ParserBet365 parserBet365;
	
	@Autowired
	private Bet365Service bet365Service;
	
	String url = "https://www.365sport365.com/SportsBook.API/web?lid=10&zid=0&cid=42&ctid=42&pd=";
	
	public void grabGpropGame(String pd, int resourceId){
	
		try {
			url = url + URLEncoder.encode(pd.substring(3), "UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		List<SportModule> sportGameList = parserBet365.parseSportModule(url, resourceId);
		
		bet365Service.saveSportGame(sportGameList);
	}

	
}
