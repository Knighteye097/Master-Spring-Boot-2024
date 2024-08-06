package com.in28minutes.learn_spring_framework;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.in28minutes.learn_spring_framework.game.GameRunner;
import com.in28minutes.learn_spring_framework.game.GamingConsole;

@Configuration
@ComponentScan("com.in28minutes.learn_spring_framework.game")
public class GameLauncherApplication {
	public static void main(String[] args) {
		try(var context = new AnnotationConfigApplicationContext(GameLauncherApplication.class)){
			context.getBean(GamingConsole.class).down();
			context.getBean(GameRunner.class).run();
		}
	}
}
