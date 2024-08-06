package com.in28minutes.learn_spring_framework.helloworld;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.in28minutes.learn_spring_framework.game.GameRunner;
import com.in28minutes.learn_spring_framework.game.PacMan;


public class App02HelloWorldSpring {
	
	public static void main(String[] args) {
		
		try(
			//1: Launch a Spring Application/ Spring Context
			var context = new AnnotationConfigApplicationContext(HelloWorldConfiguration.class);){
				
				//2: Configure the things that we want Spring to manage - @Configuration	
				System.out.println(context.getBean("name"));
				System.out.println(context.getBean("age"));
				System.out.println(context.getBean("person"));
				System.out.println(context.getBean("person2MethodCall"));
				System.out.println(context.getBean("person3Parameters"));
				System.out.println(context.getBean("person4Parameters"));
				System.out.println(context.getBean("address1"));
				System.out.println(context.getBean(Address.class));
			
		}
	}
}
