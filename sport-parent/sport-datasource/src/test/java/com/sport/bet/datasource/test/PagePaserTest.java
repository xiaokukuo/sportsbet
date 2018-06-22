package com.sport.bet.datasource.test;

import java.io.UnsupportedEncodingException;
import java.util.List;

import org.htmlcleaner.XPatherException;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.sport.bet.bean.model.SportGameOdds;
import com.sport.bet.bean.model.SportModule;
import com.sport.bet.common.utils.HttpTool;
import com.sport.bet.datasource.handler.GrapBet365Handler;
import com.sport.bet.datasource.parsing.bet365.PagePaser;
import com.sport.bet.datasource.parsing.betu1688.PageU1688Paser;
import com.sport.bet.datasource.parsing.pin1111.PagePin1111Paser;
import com.sport.bet.datasource.test.base.BaseTest;

public class PagePaserTest extends BaseTest{
	
	@Autowired
	private GrapBet365Handler grapBet365Handler;
	
	@Autowired
	private PageU1688Paser pageU1688Paser;
	
	@Autowired
	private PagePin1111Paser pagePin1111Paser;
	
	@Test
	public void paserTest(){
		PagePaser pagePaser = new PagePaser();
		pagePaser.setResourceId(1);
		String url = "https://www.365sport365.com/SportsBook.API/web?lid=10&zid=0&pd=%23AS%23B18%23&cid=42&ctid=42";
		String pageStr = HttpTool.getSport365(url);
		List<SportModule> sportModuleList = pagePaser.parsed(pageStr);
		
		for (SportModule sportModule : sportModuleList) {
			System.out.println(sportModule.toString());
		}
	}

	@Test
	public void test() throws UnsupportedEncodingException{
		grapBet365Handler.grabData(1,"");
	}
	
	@Test
	public void testUrl() throws UnsupportedEncodingException, XPatherException{
		String pageJosn = HttpTool.getSportPin111("https://www.pin1111.com/zh-cn/rtn");
		
		pagePin1111Paser.setResourceId(1);
		List<SportModule> a = pagePin1111Paser.parsed(pageJosn);
		for (SportModule sportModule : a) {
			System.out.println(sportModule.toString());
		}
		
	}
	
	@Test
	public void testUrl1688() throws XPatherException, InterruptedException {
		String pageJosnU188 = HttpTool.getSportU16888("http://www.u16888.com/zh-cn/euro/篮球");
		
		List<SportGameOdds> gameOddslist = pageU1688Paser.parsed(pageJosnU188);
		for (SportGameOdds sportGameOdds : gameOddslist) {
			System.out.println(sportGameOdds.toString());
		}
		
	}
}
