package com.sport.bet.datasource.parsing.betu1688;

import java.util.List;

import org.htmlcleaner.HtmlCleaner;
import org.htmlcleaner.TagNode;
import org.htmlcleaner.XPatherException;
import org.springframework.stereotype.Component;

import com.sport.bet.bean.model.SportGameOdds;
import com.sport.bet.datasource.parsing.AbstractPaser;
import com.sport.bet.datasource.utils.Native2AsciiUtils;

@Component
public class PageU1688Paser extends AbstractPaser<SportGameOdds> {

	@Override
	public List<SportGameOdds> parsed(String page) {

		HtmlCleaner hc = new HtmlCleaner();
		TagNode tn = hc.clean(page);
		String xpath = "//script[]";
		Object[] scriptObjArr = null;

		try {
			scriptObjArr = tn.evaluateXPath(xpath); // 找到script标签的节点
		} catch (XPatherException e) {
			e.printStackTrace();
		}

		if (scriptObjArr == null || scriptObjArr.length < 0) {
			return null;
		}

		// 遍历script标签的节点
		String scriptStr = null;
		for (Object scriptObj : scriptObjArr) {
			TagNode tna = (TagNode) scriptObj;
			scriptStr = tna.getText().toString();

			if (scriptStr.startsWith("function initiateOddsDisplay()")) {
				
				String[] scriptStrArr = scriptStr.split("\\],\\[\\],\\[\\]\\]");
				scriptStr = scriptStrArr[scriptStrArr.length-2];
				scriptStr = scriptStr.substring(scriptStr.indexOf("[[") + 8/(scriptStrArr.length-1));
				scriptStr = Native2AsciiUtils.ascii2Native(scriptStr).replace("'", "");
				
				String[] teamArr = scriptStr.split("\\],\\[2,");
				SportGameOdds gameOdds = null;
				
				for (String teamLine : teamArr) {
					teamLine = teamLine.replace("[", "");
					// System.out.println(team);
					String[] itemArr = teamLine.split("\\],");

					String teamInfoLine = itemArr[0]; // 队伍信息
					String[] teamItems = teamInfoLine.split(",");
					String groupCode = teamItems[0];
					String teamCode = teamItems[1];
					String team1Name = teamItems[2];
					String team2Name = teamItems[3];
					String gameTime = teamItems[6];

					for (int i = 2; i < itemArr.length - 1; i = i + 2) {
						String[] coefficientArr = itemArr[i].split(","); // 系数
						System.err.println("系数l" + itemArr[i]);
						String coefficient = coefficientArr[6];
						
						System.err.println("系数" + coefficient);

						String[] odds = itemArr[i + 1].replace("]]", "").split(",");

						for (int j = 0; j < odds.length; j++) {
							gameOdds = new SportGameOdds();
							gameOdds.setCid(groupCode);
							gameOdds.setEid(teamCode);
							gameOdds.setTeam(team1Name);
							gameOdds.setTeam2(team2Name);
							gameOdds.setScoreType(1);
							gameOdds.setTeamScore(odds[j]);
							if (j == 1) {
								gameOdds.setTeamNa(coefficient); // 系数
							}
							if (j == 0) {
								if (coefficient.startsWith("-")) {
									gameOdds.setTeamNa(coefficient.substring(1)); // 系数
								} else {
									gameOdds.setTeamNa("-" + coefficient); // 系数
								}
							}
							list.add(gameOdds);
						}
					}
				}
			}
		}

		return list;
	}

}
