package com.in28minutes.learn_spring_framework;

import com.in28minutes.learn_spring_framework.game.GameRunner;
import com.in28minutes.learn_spring_framework.game.PacMan;


public class App01GamingBasic {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		var game = new PacMan(); 
		var gameRunner = new GameRunner(game);
		
		gameRunner.run();

	}

}
