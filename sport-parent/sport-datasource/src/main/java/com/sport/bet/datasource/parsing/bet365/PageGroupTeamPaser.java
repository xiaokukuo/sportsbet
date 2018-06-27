package com.sport.bet.datasource.parsing.bet365;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.sport.bet.bean.model.SportGameOdds;
import com.sport.bet.common.utils.HttpTool;
import com.sport.bet.datasource.parsing.AbstractPaser;
import com.sport.bet.datasource.utils.HttpUtils;

@Component
public class PageGroupTeamPaser extends AbstractPaser<SportGameOdds> {

	Logger logger = LoggerFactory.getLogger(PageGroupTeamPaser.class);

	private volatile int gameId;

	@Override
	public List<SportGameOdds> parsed(String page) {

		String[] mgLines = page.split("\\|MG;");

		for (String mgLine : mgLines) {

			// 比赛投注
			if (mgLine.startsWith("ID=M1453")) {
				this.getGameBet(mgLine, gameId);
				continue;
			}
			// 附加比赛总分
			if (mgLine.startsWith("ID=G180114")) {
				this.getTotalScore(mgLine, gameId);
				continue;
			}

			// 附加让分
			if (mgLine.startsWith("ID=G180113")) {
				this.getExtraPoint(mgLine, gameId);
				continue;
			}

		}
		return list;
	}

	// 比赛投注
	public void getGameBet(String mgLine, int gameId) {
		String[] teamArr = new String[2];
		String[] maLines = mgLine.split("\\|MA;");
		SportGameOdds sportGameOdds = null;
		for (String maLine : maLines) {
			if (maLine.startsWith("ID=M-1453-1")) { // 队伍
				String[] paLines = maLine.split("\\|PA");
				for (int i = 1; i < paLines.length; i++) {
					teamArr[i - 1] = super.getLineValue(paLines[i], "NA");
				}
				continue;
			}

			if (maLine.startsWith("ID=M-1453-2")) { // 让分
				String[] paLines = maLine.split("\\|PA");
				for (int i = 1; i < paLines.length; i++) {
					String ha = super.getLineValue(paLines[i], "HA");
					if (ha == null || "+999".equals(ha) || "-999".equals(ha)) {
						break;
					}
					sportGameOdds = new SportGameOdds();
					sportGameOdds.setGameId(gameId);
					sportGameOdds.setScoreType(1);
					sportGameOdds.setTeam(teamArr[i - 1]);
					sportGameOdds.setTeamNa(ha);
					sportGameOdds.setTeamScore(super.getLineValue(paLines[i], "OD"));
					list.add(sportGameOdds);
				}
				continue;
			}

			if (maLine.startsWith("ID=M-1454-3")) { // 总分
				String[] paLines = maLine.split("\\|PA");

				sportGameOdds = new SportGameOdds();
				sportGameOdds.setGameId(gameId);
				sportGameOdds.setScoreType(2);
				String ha = null;
				for (int i = 1; i < paLines.length; i++) {
					String[] elements = paLines[i].split(";");
					ha = super.getLineValue(elements, "HA");
					if (ha == null || "+999".equals(ha) || "-999".equals(ha)) {
						ha = null;
						break;
					}
					String na = super.getLineValue(elements, "NA");
					if (na.startsWith("高")|| na.startsWith("O")) {
						sportGameOdds.setScore(ha);
						sportGameOdds.setHigher(super.getLineValue(elements, "OD"));
					}
					if (na.startsWith("低") ||  na.startsWith("U")) {
						sportGameOdds.setLower(super.getLineValue(elements, "OD"));
					}
				}
				if (ha != null) {
					list.add(sportGameOdds);
				}

				continue;
			}

			if (maLine.startsWith("ID=M-960-4")) { // 强弱盘赔率 赌赢盘
				String[] paLines = maLine.split("\\|PA");
				for (int i = 1; i < paLines.length; i++) {
					String od = super.getLineValue(paLines[i], "OD");
					if (od == null || od.length() == 0 || od.trim() == "") {
						break;
					}
					sportGameOdds = new SportGameOdds();
					sportGameOdds.setGameId(gameId);
					sportGameOdds.setScoreType(3);
					sportGameOdds.setTeam(teamArr[i - 1]);
					sportGameOdds.setSingleWinerScore(od);
					list.add(sportGameOdds);
				}
				continue;
			}
		}
	}

	// 总分
	public void getTotalScore(String mgLine, int gameId) {
		String[] semicolonLines = mgLine.split(";");
		for (String line : semicolonLines) {
			if (line.startsWith("PD")) {
				String pd = line.substring(3);
				String responseStr = HttpTool.getSport365(HttpUtils.getUrl356("en",pd));
				if (responseStr == null) {
					break;
				}
				String[] mgLinesG114 = responseStr.split("\\|MA;");

				// 第n列
				String[] column1 = mgLinesG114[1].split("\\|PA;");
				String[] column2 = mgLinesG114[2].split("\\|PA;");
				String[] column3 = mgLinesG114[3].split("\\|PA;");

				String[] column4 = mgLinesG114[4].split("\\|PA;");
				String[] column5 = mgLinesG114[5].split("\\|PA;");
				String[] column6 = mgLinesG114[6].split("\\|PA;");

				int length1 = column1.length;
				int length2 = column4.length;
				if (length1 > 1 && length1 == column2.length && length1 == column3.length && length2 > 1
						&& length2 == column5.length && length2 == column6.length) {

					SportGameOdds gameOdds = null;

					for (int i = 1; i < length1; i++) {
						gameOdds = new SportGameOdds();
						gameOdds.setGameId(gameId);
						gameOdds.setScoreType(2);
						gameOdds.setScore(column1[i].split(";")[2].substring(3));
						gameOdds.setHigher(column2[i].split(";")[2].substring(3));
						gameOdds.setLower(column3[i].split(";")[2].substring(3));
						list.add(gameOdds);
					}
					for (int i = 1; i < length2; i++) {
						gameOdds = new SportGameOdds();
						gameOdds.setGameId(gameId);
						gameOdds.setScoreType(2);
						gameOdds.setScore(column4[i].split(";")[2].substring(3));
						gameOdds.setHigher(column5[i].split(";")[2].substring(3));
						gameOdds.setLower(column6[i].split(";")[2].substring(3));
						list.add(gameOdds);
					}
				}
				break;
			}
		}
	}

	// 附加分
	public void getExtraPoint(String mgLine, int gameId) {
		String[] semicolonLines = mgLine.split(";");
		for (String line : semicolonLines) {
			if (line.startsWith("PD")) {
				String pd = line.substring(3);
				String responseStr = HttpTool.getSport365(HttpUtils.getUrl356("en", pd));
				if (responseStr == null) {
					break;
				}
				String[] mgLinesG114 = responseStr.split("\\|MA;");

				String[] column1 = mgLinesG114[1].split("\\|PA;");
				String[] column2 = mgLinesG114[2].split("\\|PA;");

				int length = column1.length;
				if (length <= 0 || length != column2.length) {
					return;
				}

				SportGameOdds gameOdds = null;
				String teamName1 = getLineValue(column1[0].split(";"), "NA=");
				String teamName2 = getLineValue(column2[0].split(";"), "NA=");

				for (int i = 1; i < length; i++) {
					String[] colLines = column1[i].split(";");
					gameOdds = new SportGameOdds();
					gameOdds.setGameId(gameId);
					gameOdds.setScoreType(1);
					gameOdds.setTeam(teamName1);
					gameOdds.setTeamNa(super.getLineValue(colLines, "NA="));
					gameOdds.setTeamScore(super.getLineValue(colLines, "OD="));
					list.add(gameOdds);

					String[] colLines2 = column2[i].split(";");
					gameOdds = new SportGameOdds();
					gameOdds.setGameId(gameId);
					gameOdds.setScoreType(1);
					gameOdds.setTeam(teamName2);
					gameOdds.setTeamNa(super.getLineValue(colLines2, "NA="));
					gameOdds.setTeamScore(super.getLineValue(colLines2, "OD="));
					list.add(gameOdds);
				}
				break;
			}
		}
	}

	public int getGameId() {
		return gameId;
	}

	public void setGameId(int gameId) {
		this.gameId = gameId;
	}
	
}
