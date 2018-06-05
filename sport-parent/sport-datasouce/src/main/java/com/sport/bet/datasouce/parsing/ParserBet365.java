package com.sport.bet.datasouce.parsing;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.sport.bet.bean.dto.SportMenuDTO;
import com.sport.bet.bean.model.SportModule;
import com.sport.bet.bean.model.SportModuleGame;
import com.sport.bet.common.utils.HttpTool;
import com.sport.bet.datasouce.utils.HttpUtils;

@Component
public class ParserBet365 extends GenericParser{

	private static String  SEPARATOR_CL = "\\|CL;";
	
	private static String  SEPARATOR_EV = "\\|EV;";
	
	private static String  SEPARATOR_MA = "\\|MA;";
	
	private static String  SEPARATOR_PA = "\\|PA;";
	
	private static String  EV= "|EV;";

	@Override
	public List<SportMenuDTO> parseMenu(String url) {
		
		List<SportMenuDTO> sportMenuList = new ArrayList<SportMenuDTO>();
		SportMenuDTO sprotMenu= null;
		
		String response = HttpTool.getSport365(url);
		if(!response.startsWith("F|CL;") || !response.endsWith("|")){
			System.err.println("返回报文错误");
		}
		
		String [] menuLines = response.split(SEPARATOR_CL);
		
		for (String menuLine : menuLines) {
			if(menuLine.contains(EV) || menuLine.startsWith("F") || menuLine.substring(3).startsWith("-")){
				continue;
			}
			
			String menuLineTemp = menuLine.substring(menuLine.indexOf("NA"));
			String[] elements = menuLineTemp.split("\\;");

			sprotMenu = new SportMenuDTO();
			sprotMenu.setSportName(elements[0].substring(3));
			sprotMenu.setSportPd(elements[1].substring(3));
			
			sportMenuList.add(sprotMenu);
		}
		
		return sportMenuList;
	}

	//https://www.365sport365.com/SportsBook.API/web?lid=10&zid=0&cid=42&ctid=42&pd=%23AS%23B18%23
	@Override
	public List<SportModule> parseSportModule(String url, int resourceId) {
		List<SportModule> sportModuleList = new ArrayList<SportModule>();
		SportModule sportModule = null;
		
		String response = HttpTool.getSport365(url);
		
		if(!response.startsWith("F|CL;") || !response.endsWith("|")){
			System.err.println("返回报文错误");
		}
		
		String [] sportGroupLines = response.split(SEPARATOR_EV);
		
		for (String sportGroupLine : sportGroupLines) {
			if(!sportGroupLine.contains("比赛投注")){
				continue;
			}
			sportModule = new SportModule();
			sportModule.setResourceId(resourceId);
			String groupName = sportGroupLine.substring(0,sportGroupLine.indexOf(";DO"));
			sportModule.setGroupName(groupName.split(";")[1].substring(3));
			
			this.parseGroupLine(sportGroupLine, sportModule);
			
			sportModuleList.add(sportModule);
		}
		
		return sportModuleList;
	}
	
	@Override
	public List<SportModuleGame> parseSportModuleGame(String url,int resourceId, int moduleId) {
		List<SportModuleGame> gameTeamList = new ArrayList<SportModuleGame>();
		SportModuleGame gameTeam = null;
		
		String response = HttpTool.getSport365(url);
		
		String [] gameLines = response.split(SEPARATOR_MA);
		
		for (String gameline : gameLines) {
			
			int timeIndex = gameline.indexOf(";BC");
			if(timeIndex > 0){
				
				gameline = gameline.substring(gameline.indexOf("PA;NA")+6);
				String[] teams = gameline.split("PA;NA=");
				for (int i = 0; i < teams.length; i=i+2) {
					
					String item1 = teams[i];
					String item2 = teams[i+1];
					
					int index = item1.indexOf("PD");
					timeIndex = item1.indexOf("BC");
					if(index > 0 && timeIndex > 0){
						gameTeam = new SportModuleGame();
						gameTeam.setResourceId(resourceId);
						gameTeam.setSportGroupId(moduleId);
						gameTeam.setTeamName1(item1.substring(0, item1.indexOf(";"))); 
						gameTeam.setTeamName2(item2.substring(0, item2.indexOf(";"))); 
						
						item1 = item1.substring(item1.indexOf("BC"));
						item2 = item2.substring(item2.indexOf("PD"));
						
						gameTeam.setGameTime(item1.substring(3,item1.indexOf(";")));
						gameTeam.setDeailPd(item2.substring(3,item2.indexOf(";")));
						gameTeamList.add(gameTeam);
						
					}
				}
				
			}
		}
		
		return gameTeamList;
	}
	
	@Override
	public void parseSportGameScore(String url, int resourceId, int gameId) {
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
			if(mgLine.startsWith("ID=G180114")){
				System.err.println(mgLine);
				String[] semicolonLines = mgLine.split(";");
				for (String line : semicolonLines) {
					if(line.startsWith("PD")){
						String pd = line.substring(3);
						String responseStr = HttpTool.getSport365(HttpUtils.getUrl356(pd));

						String [] mgLinesG114 = responseStr.split("\\|MA;");
						
						//第n列
						String[] column1 = mgLinesG114[1].split("\\|PA;");
						String[] column2 = mgLinesG114[2].split("\\|PA;");
						String[] column3 = mgLinesG114[3].split("\\|PA;");
						String[] column4 = mgLinesG114[3].split("\\|PA;");
						String[] column5 = mgLinesG114[3].split("\\|PA;");
						String[] column6 = mgLinesG114[3].split("\\|PA;");
						
						int length = column1.length;
						if(length > 1 && length == column2.length && length == column3.length 
								&& length == column4.length && length == column5.length 
								&& length == column6.length){
							
							for (int i = 1; i < length; i++) {
								String tatalScore = column1[i];
								String higher  = column2[2];
								String lower = column3[2];
							}
						}
						
					}
				}
				continue;
			}
			//附加让分
			/*if(mgLine.startsWith("ID=G180113")){
				System.out.println(mgLine);
				continue;
			}*/
			
		}
	}
	
	private void parseGroupLine(String line,SportModule sportModule){
		String [] elements = line.split(SEPARATOR_MA);
		int lenght = 0;
		for (String ele : elements) {
			if(ele.contains("投注盘")){
				String [] items = ele.split(SEPARATOR_PA);
				for (String item : items) {
					lenght = item.length()-5;
					if(item.contains("比赛投注")){
						sportModule.setGameLinesPd(item.substring(item.indexOf("PD")+3, lenght));
					}
					if(item.contains("上半场")){
						sportModule.setFirstHalfPd(item.substring(item.indexOf("PD")+3, lenght));
					}
					if(item.contains("下半场")){
						sportModule.setSecondHalfPd(item.substring(item.indexOf("PD")+3, lenght));
					}
					if(item.contains("第1赛节")){
						sportModule.setFirstQuarterPd(item.substring(item.indexOf("PD")+3, lenght));
					}
					if(item.contains("第2赛节")){
						sportModule.setSecondQuarterPd(item.substring(item.indexOf("PD")+3, lenght));
					}
					if(item.contains("第3赛节")){
						sportModule.setThirdQuarterPd(item.substring(item.indexOf("PD")+3, lenght));
					}
					if(item.contains("第4赛节")){
						sportModule.setFourthQuarterPd(item.substring(item.indexOf("PD")+3, lenght));
					}
				}
				break;
			}
			
		}
	}

	
	
}
