package com.sport.bet.batch.controller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;


@ComponentScan
@SpringBootApplication(scanBasePackages={"com.sport.bet"})
@PropertySources({
	@PropertySource(encoding="UTF-8",value={"classpath:/config/jdbc.properties"}),
})
public class BatchApplication {

	public static void main(String[] args) {
		SpringApplication.run(BatchApplication.class, args);
	}
}
