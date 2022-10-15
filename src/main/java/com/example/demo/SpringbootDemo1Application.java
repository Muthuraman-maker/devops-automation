package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.example.demo.service.OwnerService;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@SpringBootApplication
//@EnableWebSecurity(debug = true)
@OpenAPIDefinition(info = @Info(title = "Sample SpringBoot API's", version = "2.0", description = "List of Sample API's for understandin"))
public class SpringbootDemo1Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootDemo1Application.class, args);
		System.out.println("Hai the application is started...");
		//ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringbootDemo1Application.class);

		//By its type
		//OwnerService user = ctx.getBean(OwnerService.class);
		//By its alias name
		
		
		//OwnerService user = (OwnerService)ctx.getBean("myBean");
		//System.out.println("Printing user:"+user.getList());
	}

}
