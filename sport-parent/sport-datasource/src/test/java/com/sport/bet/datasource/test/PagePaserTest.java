package com.sport.bet.datasource.test;

import java.io.UnsupportedEncodingException;
import java.util.List;

import org.htmlcleaner.HtmlCleaner;
import org.htmlcleaner.TagNode;
import org.htmlcleaner.XPatherException;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.sport.bet.bean.model.SportModule;
import com.sport.bet.common.utils.HttpTool;
import com.sport.bet.datasource.handler.GrapBet365Handler;
import com.sport.bet.datasource.parsing.bet365.PagePaser;
import com.sport.bet.datasource.test.base.BaseTest;

public class PagePaserTest extends BaseTest{
	
	@Autowired
	private GrapBet365Handler grapBet365Handler;
	
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
		grapBet365Handler.grabGroupModule();
	}
	
	@Test
	public void testUrl() throws UnsupportedEncodingException{
		String pageJosn = HttpTool.getSportPin111("https://www.pin1111.com/zh-cn/odds/today/basketball");
		System.err.println(pageJosn);
		
	}
	
	@Test
	public void testUrl1688() throws XPatherException {
		HttpTool.getSportU16888("http://www.u16888.com/zh-cn/data/favourite?tk=ec7ddc67,0,0&act=g&uid=0");
		HttpTool.getSportU16888("http://www.u16888.com/zh-cn/data/right-promo?act=g&sid=2");
		String pageJosnU188 = HttpTool.getSportU16888("http://www.u16888.com/zh-cn/euro/篮球/美国");
		HtmlCleaner hc = new HtmlCleaner();         
		TagNode tn = hc.clean(pageJosnU188); 
		
		
		
		System.out.println(pageJosnU188);
		
		/*String xpath = "//li[@id='ms-all-sp-2']//div[@id='ms-all-res-2']//ul[@id='ms-all-res-ul-2']//li[@class='UnSel']";        
		Object[] objarr = null; 
		objarr = tn.evaluateXPath(xpath); 
		if (objarr != null && objarr.length > 0) { 
			 for (Object obj : objarr) { 
				 TagNode tntr = (TagNode) obj;                 
				 String xptr = "//a//div"; 
				 Object[] objarrtr = null;                 
				 objarrtr = tntr.evaluateXPath(xptr); 
				 
				 if (objarrtr != null && objarrtr.length > 0) { 
					 for (Object obja : objarrtr) { 
						 TagNode tna = (TagNode) obja;                         
						 String str = tna.getText().toString(); 
						 
						 System.err.println(str);
					 }
				 }
			 }
			
		}*/
		
	}
}
