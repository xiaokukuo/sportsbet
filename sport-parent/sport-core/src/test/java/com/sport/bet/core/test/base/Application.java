package com.sport.bet.core.test.base;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

import com.sport.bet.common.utils.mybatis.MapperNameGenerator;

@SpringBootApplication(scanBasePackages={"com.sport.bet.core"})
@PropertySources({
	@PropertySource(encoding="UTF-8",value={"classpath:/config/jdbc.properties"}),
})
@MapperScan(value = {"com.sport.bet.core.mapper"},nameGenerator = MapperNameGenerator.class)
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	
	/*ViewBean view = new ViewBean();
	view.setType("让分");
	view.setWebsite1("365");
	view.setWebsite2("188");
	view.setTeam1(odds365.getTeamName1());
	view.setTeam2(odds365.getTeamName2());
	view.setLetCoefficient1(odds365.getTeamNa());
	view.setLetCoefficient2(teamNA);
	view.setLetScore1(teamScore365+"");
	view.setLetScore2(Double.parseDouble(odds188.getTeamScore())+"");
	
	view.setProfit(a+"");
	//System.out.println(view.toString());
	viewList.add(view);*/
}
