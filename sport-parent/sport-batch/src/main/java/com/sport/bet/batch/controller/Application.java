package com.sport.bet.batch.controller;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/*@SpringBootApplication(scanBasePackages={"com.sport.bet.batch.controller"})
@PropertySources({
	@PropertySource(encoding="UTF-8",value={"classpath:/config/jdbc.properties"}),
})*/
@ComponentScan
@SpringBootApplication(scanBasePackages={"com.sport.bet.batch.controller", "com.sport.bet.quartz"})
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
