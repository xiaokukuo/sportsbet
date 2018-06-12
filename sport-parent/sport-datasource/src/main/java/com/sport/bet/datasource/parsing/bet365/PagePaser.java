package com.sport.bet.datasource.parsing.bet365;

import java.util.HashMap;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sport.bet.bean.model.SportModule;
import com.sport.bet.datasource.parsing.AbstractPaser;
import com.sport.bet.datasource.utils.StringUtils;

public class PagePaser extends AbstractPaser<SportModule> {
	
	Logger logger = LoggerFactory.getLogger(PagePaser.class);
	
	private int resourceId;
	
	public static HashMap<String, String> maItem = new HashMap<String, String>();
	
	static{
		maItem.put("","");
	}
	
	@Override
	public List<SportModule> parsed(String page) {
		
		SportModule sportModule = null;

		if (!page.startsWith("F|CL") || !page.endsWith("|")) {
			logger.error("返回报文错误");
			return null;
		}

		String[] sportGroupLines = page.split(SEPARATOR_EV);
		
		for (int i = 1; i < sportGroupLines.length; i++) {
			
			String sportGroupLine = sportGroupLines[i];
			if(!sportGroupLine.startsWith("IT=-")){
				continue;
			}
			
			String[] titles =  sportGroupLine.split(SEPARATOR_MA);
			
			String groupName = StringUtils.substring(titles[0], "NA=", ";DO");
			
			sportModule = new SportModule();
			sportModule.setResourceId(resourceId);
			sportModule.setGroupName(groupName);

			this.parseGroupLine(titles[1], sportModule);
			list.add(sportModule);
		}
		return list;
	}
	
	private void parseGroupLine(String line, SportModule sportModule) {
		String[] items = line.split(SEPARATOR_PA);
		for (int i = 1; i < items.length; i++) {
			String item = items[i];
			String na = StringUtils.substring(item, "NA=", ";XB");
			String pd = StringUtils.substring(item, "PD=", ";FF");
			switch (na) {
				case "比赛投注": sportModule.setGameLinesPd(pd);
					break;
				case "上半场": sportModule.setFirstHalfPd(pd);
					break;
				case "下半场": sportModule.setSecondHalfPd(pd);
					break;
				case "第1赛节": sportModule.setFirstQuarterPd(pd);
					break;
				case "第2赛节": sportModule.setSecondQuarterPd(pd);
					break;
				case "第3赛节": sportModule.setThirdQuarterPd(pd);
					break;
				case "第4赛节": sportModule.setFourthQuarterPd(pd);
					break;
				default:
					break;
			}
			
		}
		
	}
}
