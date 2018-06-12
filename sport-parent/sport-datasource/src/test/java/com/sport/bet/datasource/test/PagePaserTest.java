package com.sport.bet.datasource.test;

import java.util.List;

import org.junit.Test;

import com.sport.bet.bean.model.SportModule;
import com.sport.bet.common.utils.HttpTool;
import com.sport.bet.datasource.parsing.bet365.PagePaser;
import com.sport.bet.datasource.test.base.BaseTest;

public class PagePaserTest extends BaseTest{
	
	@Test
	public void paserTest(){
		PagePaser pagePaser = new PagePaser();
		String url = "https://www.365sport365.com/SportsBook.API/web?lid=10&zid=0&pd=%23AS%23B18%23&cid=42&ctid=42";
		String pageStr = HttpTool.getSport365(url);
		List<SportModule> sportModuleList = pagePaser.parsed(pageStr);
		System.out.println(sportModuleList);
	}

}
