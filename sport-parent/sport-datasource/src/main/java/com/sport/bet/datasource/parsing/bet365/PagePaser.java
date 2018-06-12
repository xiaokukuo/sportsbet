package com.sport.bet.datasource.parsing.bet365;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.sport.bet.bean.model.SportModule;
import com.sport.bet.datasource.parsing.AbstractPaser;

@Component
@Scope
public class PagePaser extends AbstractPaser<SportModule> {
	
	Logger logger = LoggerFactory.getLogger(PagePaser.class);
	
	private int resourceId;
	
	@Override
	public List<SportModule> parsed(String page) {
		
		SportModule sportModule = null;

		if (!page.startsWith("F|CL") || !page.endsWith("|")) {
			logger.error("返回报文错误");
			return null;
		}

		String[] sportGroupLines = page.split(SEPARATOR_EV);

		for (String sportGroupLine : sportGroupLines) {
			if (!sportGroupLine.contains("比赛投注")) {
				continue;
			}
			sportModule = new SportModule();
			sportModule.setResourceId(resourceId);
			String groupName = sportGroupLine.substring(0, sportGroupLine.indexOf(";DO"));
			sportModule.setGroupName(groupName.split(";")[1].substring(3));

			this.parseGroupLine(sportGroupLine, sportModule);

			list.add(sportModule);
		}

		return list;
	}
	
	private void parseGroupLine(String line, SportModule sportModule) {
		String[] elements = line.split(SEPARATOR_MA);
		int lenght = 0;
		for (String ele : elements) {
			if (ele.contains("投注盘")) {
				String[] items = ele.split(SEPARATOR_PA);
				for (String item : items) {
					lenght = item.length() - 5;
					if (item.contains("比赛投注")) {
						sportModule.setGameLinesPd(item.substring(item.indexOf("PD") + 3, lenght));
					}
					if (item.contains("上半场")) {
						sportModule.setFirstHalfPd(item.substring(item.indexOf("PD") + 3, lenght));
					}
					if (item.contains("下半场")) {
						sportModule.setSecondHalfPd(item.substring(item.indexOf("PD") + 3, lenght));
					}
					if (item.contains("第1赛节")) {
						sportModule.setFirstQuarterPd(item.substring(item.indexOf("PD") + 3, lenght));
					}
					if (item.contains("第2赛节")) {
						sportModule.setSecondQuarterPd(item.substring(item.indexOf("PD") + 3, lenght));
					}
					if (item.contains("第3赛节")) {
						sportModule.setThirdQuarterPd(item.substring(item.indexOf("PD") + 3, lenght));
					}
					if (item.contains("第4赛节")) {
						sportModule.setFourthQuarterPd(item.substring(item.indexOf("PD") + 3, lenght));
					}
				}
				break;
			}

		}
	}
}
