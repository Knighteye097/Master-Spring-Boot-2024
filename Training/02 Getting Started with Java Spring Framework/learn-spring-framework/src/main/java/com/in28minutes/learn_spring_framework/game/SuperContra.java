package com.in28minutes.learn_spring_framework.game;

public class SuperContra implements GamingConsole{

	@Override
	public void up() {
		// TODO Auto-generated method stub
		System.out.println("Up");
		
	}

	@Override
	public void down() {
		// TODO Auto-generated method stub
		System.out.println("Sit");
	}

	@Override
	public void left() {
		// TODO Auto-generated method stub
		System.out.println("Go back");
	}

	@Override
	public void right() {
		// TODO Auto-generated method stub
		System.out.println("Shoot bullet");
		
	}

}
