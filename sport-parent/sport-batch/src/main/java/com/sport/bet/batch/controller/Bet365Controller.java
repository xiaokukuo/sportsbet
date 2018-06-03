package com.sport.bet.batch.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sport.bet.bean.dto.SportMenuDTO;
import com.sport.bet.datasouce.parsing.ParserBet365;
import com.sport.bet.datasouce.service.Bet365Service;

@Controller
@RequestMapping("/bet365")
public class Bet365Controller {

	@Autowired
	private ParserBet365 parserBet365;
	
	@Autowired
	private Bet365Service bet365Service;
	
	@RequestMapping(method = {RequestMethod.GET}, value = "/grab/menu")
	@ResponseBody
	public List<SportMenuDTO> grabBet365Menu() {
		
	//	List<Sport> sportList = parserBet365.parseMenu("https://www.365sport365.com/SportsBook.API/web?lid=10&zid=0&pd=%23AL%23&cid=42&ctid=42",1);
		
		return null;//bet365Service.saveSportMenu(sportList);
		
	}
	
}
