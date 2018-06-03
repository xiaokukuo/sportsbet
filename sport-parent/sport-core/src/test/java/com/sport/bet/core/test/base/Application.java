package com.sport.bet.core.test.base;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

import com.sport.bet.common.utils.mybatis.MapperNameGenerator;

@SpringBootApplication(scanBasePackages={"com.sport.bet.core.service","com.sport.bet.core.mapper"})
@PropertySources({
	@PropertySource(encoding="UTF-8",value={"classpath:/config/jdbc.properties"}),
})
@MapperScan(value = {"com.sport.bet.core.mapper"},nameGenerator = MapperNameGenerator.class)
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
