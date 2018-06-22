package com.sport.bet.datasource.parsing.bet365;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.sport.bet.bean.model.SportModuleGame;
import com.sport.bet.datasource.parsing.AbstractPaser;

@Component
public class PageGroupPaser extends AbstractPaser<SportModuleGame> {
	
	Logger logger = LoggerFactory.getLogger(PageGroupPaser.class);
	
	private volatile int moduleId;
	
	@Override
	public List<SportModuleGame> parsed(String groupPage) {
		//list.clear();
		SportModuleGame gameTeam = null;

		String[] gameLines = groupPage.split(SEPARATOR_MA);

		for (String gameline : gameLines) {

			int timeIndex = gameline.indexOf(";BC");
			if (timeIndex > 0) {

				gameline = gameline.substring(gameline.indexOf("PA;NA") + 6);
				String[] teams = gameline.split("PA;NA=");
				for (int i = 0; i < teams.length; i = i + 2) {

					String item1 = teams[i];
					String item2 = teams[i + 1];

					int index = item1.indexOf("PD");
					timeIndex = item1.indexOf("BC");
					if (index > 0 && timeIndex > 0) {
						gameTeam = new SportModuleGame();
						gameTeam.setResourceId(resourceId);
						gameTeam.setSportGroupId(moduleId);
						gameTeam.setTeamName1(item1.substring(0, item1.indexOf(";")));
						gameTeam.setTeamName2(item2.substring(0, item2.indexOf(";")));

						item1 = item1.substring(item1.indexOf("BC"));
						item2 = item2.substring(item2.indexOf("PD"));

						gameTeam.setGameTime(item1.substring(3, item1.indexOf(";")));
						gameTeam.setDeailPd(item2.substring(3, item2.indexOf(";")));
						list.add(gameTeam);

					}
				}

			}
		}

		return list;
	}

	public int getResourceId() {
		return resourceId;
	}

	public void setResourceId(int resourceId) {
		this.resourceId = resourceId;
	}

	public int getModuleId() {
		return moduleId;
	}

	public void setModuleId(int moduleId) {
		this.moduleId = moduleId;
	}

}
