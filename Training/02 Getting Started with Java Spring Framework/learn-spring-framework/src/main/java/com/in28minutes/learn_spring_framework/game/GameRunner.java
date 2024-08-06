package com.in28minutes.learn_spring_framework.game;

public class GameRunner {
	
	public GamingConsole game;

	public GameRunner(GamingConsole game) {
		// TODO Auto-generated constructor stub
		this.game = game;
	}
	
	public void run() {
		System.out.println("Game Running : " + this.game);
		this.game.up();
		this.game.down();
		this.game.left();
		this.game.right();
	}

}
