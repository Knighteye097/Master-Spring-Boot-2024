package com.in28minutes.learn_spring_framework;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.in28minutes.learn_spring_framework.game.GameRunner;
import com.in28minutes.learn_spring_framework.game.GamingConsole;
import com.in28minutes.learn_spring_framework.game.MarioGame;
import com.in28minutes.learn_spring_framework.game.PacMan;
import com.in28minutes.learn_spring_framework.game.SuperContra;

@Configuration
public class GamingConfiguration {

	@Bean
	public GamingConsole marioGame() {
		return new MarioGame();
	}
	
	@Bean
	@Qualifier("SuperContra")
	public GamingConsole superContra() {
		return new SuperContra();
	}
	
	@Bean
	@Qualifier("PacMan")
	public GamingConsole pacMan() {
		return new PacMan();
	}
	
	@Bean
	public GameRunner gameRunnerForMario(GamingConsole marioGame) {
		return new GameRunner(marioGame);
	}
	
	@Bean
	public GameRunner gameRunnerForContra(GamingConsole superContra) {
		return new GameRunner(superContra);
	}
	
	@Bean
	public GameRunner gameRunnerForPacMan(GamingConsole pacMan) {
		return new GameRunner(pacMan);
	}
}
