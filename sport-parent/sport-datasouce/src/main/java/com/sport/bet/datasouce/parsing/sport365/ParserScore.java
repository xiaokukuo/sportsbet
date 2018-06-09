package com.sport.bet.datasouce.parsing.sport365;

import java.util.List;

import com.sport.bet.bean.model.SportGameOdds;
import com.sport.bet.common.utils.HttpTool;
import com.sport.bet.datasouce.utils.HttpUtils;

public class ParserScore {

	private List<SportGameOdds> sportGameOddsList;
	
	
	public void parseSportGameScore(String url, int resourceId, int gameId,String team1,String team2) {
		String response = HttpTool.getSport365(url);
		String [] mgLines = response.split("\\|MG;");
		
		for (String mgLine : mgLines) {
			
			//比赛投注
			/*if(mgLine.startsWith("ID=M1453")){
				String[] maLines = mgLine.split("\\|MA;");
				for (int i = 1; i < maLines.length; i++) {
					System.err.println(maLines[i]);
				}
				continue;
			}*/
			//附加比赛总分
			/*if(mgLine.startsWith("ID=G180114")){
				String[] semicolonLines = mgLine.split(";");
				for (String line : semicolonLines) {
					if(line.startsWith("PD")){
						String pd = line.substring(3);
						String responseStr = HttpTool.getSport365(HttpUtils.getUrl356(pd));
						if(responseStr == null){
							break;
						}
						getTotalScore(responseStr);
						break;
					}
				}
				
			}*/
			//附加让分
			if(mgLine.startsWith("ID=G180113")){
				String[] semicolonLines = mgLine.split(";");
				
				for (String line : semicolonLines) {
					System.out.println(line);
					if(line.startsWith("PD")){
						String pd = line.substring(3);
						String responseStr = HttpTool.getSport365(HttpUtils.getUrl356(pd));
						
						
						if(responseStr == null){
							break;
						}
						
						String [] mgLinesG114 = responseStr.split("\\|MA;");
						
						for (int i = 0; i < mgLinesG114.length; i++) {
							System.err.println(mgLinesG114[i]);
						}
						
						break;
					}
				
				}
				
				continue;
			}
			
		}
	}
	
	//比赛投注
	public void getGameBet(String responseStr){
		
	}
	
	//附加分
	public void getExtraPoint(String responseStr){
		
	}
	
	//总分
	public void getTotalScore(String responseStr){
		String [] mgLinesG114 = responseStr.split("\\|MA;");
		
		//第n列
		String[] column1 = mgLinesG114[1].split("\\|PA;");
		String[] column2 = mgLinesG114[2].split("\\|PA;");
		String[] column3 = mgLinesG114[3].split("\\|PA;");
		
		String[] column4 = mgLinesG114[4].split("\\|PA;");
		String[] column5 = mgLinesG114[5].split("\\|PA;");
		String[] column6 = mgLinesG114[6].split("\\|PA;");
		
		int length1 = column1.length;
		int length2 = column4.length;
		if(length1 > 1 && length1 == column2.length && length1 == column3.length 
				&& length2>1 && length2 == column5.length 
				&& length2 == column6.length){
			
			SportGameOdds gameOdds = null;
			
			for (int i = 1; i < length1; i++) {
				gameOdds = new SportGameOdds();
				gameOdds.setScore(column1[i].split(";")[2].substring(3));
				gameOdds.setHigher(column2[i].split(";")[2].substring(3));
				gameOdds.setLower(column3[i].split(";")[2].substring(3));
				sportGameOddsList.add(gameOdds);
				System.out.println(gameOdds.toString());
			}
			for (int i = 0; i < length2; i++) {
				gameOdds = new SportGameOdds();
				gameOdds.setScore(column4[i].split(";")[2].substring(3));
				gameOdds.setHigher(column5[i].split(";")[2].substring(3));
				gameOdds.setLower(column6[i].split(";")[2].substring(3));
				sportGameOddsList.add(gameOdds);
				System.out.println(gameOdds.toString());
			}
		}
	}

	public List<SportGameOdds> getSportGameOddsList() {
		return sportGameOddsList;
	}

	public void setSportGameOddsList(List<SportGameOdds> sportGameOddsList) {
		this.sportGameOddsList = sportGameOddsList;
	}
	
	
	
}
