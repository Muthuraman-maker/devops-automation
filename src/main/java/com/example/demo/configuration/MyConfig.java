package com.example.demo.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.demo.service.OwnerService;

//@Configuration annotation tells Spring container that there are one or more beans that need to be dealt with on runtime.
@Configuration
public class MyConfig {

	@Bean(name={"myBean", "mySecondBean"})
    public OwnerService getUser() {
        return new OwnerService();
    }
	
}
