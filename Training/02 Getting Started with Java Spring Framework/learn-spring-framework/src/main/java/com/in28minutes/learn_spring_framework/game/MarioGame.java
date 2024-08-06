package com.in28minutes.learn_spring_framework.game;

public class MarioGame implements GamingConsole{

	@Override
	public void up() {
		// TODO Auto-generated method stub
		System.out.println("Jump");
		
	}

	@Override
	public void down() {
		// TODO Auto-generated method stub
		System.out.println("Do nothing/Move inside the manhole");
	}

	@Override
	public void left() {
		// TODO Auto-generated method stub
		System.out.println("Move backwards");
		
	}

	@Override
	public void right() {
		// TODO Auto-generated method stub
		System.out.println("Move Forwards");
	}

}
