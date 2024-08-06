package com.in28minutes.learn_spring_framework;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.in28minutes.learn_spring_framework.resources.BusinessCalculationService;


@Configuration
@ComponentScan("com.in28minutes.learn_spring_framework.resources")
public class SpringApplicationLauncher {
	public static void main(String[] args) {
		try(var context = new AnnotationConfigApplicationContext(SpringApplicationLauncher.class) ){
			System.out.println(context.getBean(BusinessCalculationService.class).findMax());
		}
	}
}
