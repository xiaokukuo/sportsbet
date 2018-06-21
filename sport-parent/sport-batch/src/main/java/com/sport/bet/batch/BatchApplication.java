package com.sport.bet.batch;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

@SpringBootApplication(scanBasePackages={
		"com.sport.bet.core",
		"com.sport.bet.quartz",
		"com.sport.bet.batch"})
@PropertySources({
	@PropertySource(encoding="UTF-8",value={"classpath:/config/jdbc.properties"})
})
@MapperScan(value = {"com.sport.bet.core.mapper"},nameGenerator = MapperNameGenerator.class)
public class BatchApplication {

	public static void main(String[] args) {
		SpringApplication.run(BatchApplication.class, args);
	}
}
