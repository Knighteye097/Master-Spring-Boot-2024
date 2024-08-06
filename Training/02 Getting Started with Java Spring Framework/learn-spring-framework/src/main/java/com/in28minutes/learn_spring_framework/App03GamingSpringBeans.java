package com.in28minutes.learn_spring_framework;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.in28minutes.learn_spring_framework.game.GameRunner;

public class App03GamingSpringBeans {
	public static void main(String[] args) {
		try(var context = new AnnotationConfigApplicationContext(GamingConfiguration.class)){
			
		 System.out.println(context.getBean("marioGame"));
		 System.out.println(context.getBean("superContra"));
		 System.out.println(context.getBean("pacMan"));
		 ((GameRunner) context.getBean("gameRunnerForMario")).run();
		 ((GameRunner)context.getBean("gameRunnerForContra")).run();
		 ((GameRunner)context.getBean("gameRunnerForPacMan")).run();
			
		}
	}
}
