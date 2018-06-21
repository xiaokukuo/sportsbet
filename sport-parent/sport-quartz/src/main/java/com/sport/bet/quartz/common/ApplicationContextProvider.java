package com.sport.bet.quartz.common;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;


@Component
@Scope("singleton")
public class ApplicationContextProvider implements ApplicationContextAware {
	
	private static ApplicationContext context;

    public static ApplicationContext getApplicationContext() {
        return context;
    }

    @Override
    public void setApplicationContext(ApplicationContext ctx) {
        context = ctx;
    }

}
