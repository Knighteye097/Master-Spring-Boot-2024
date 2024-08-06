package com.in28minutes.learn_spring_framework.game;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class PacMan implements GamingConsole{

	@Override
	public void up() {
		// TODO Auto-generated method stub
		System.out.println("Move up");
		
	}

	@Override
	public void down() {
		// TODO Auto-generated method stub
		System.out.println("Move Down");
		
	}

	@Override
	public void left() {
		// TODO Auto-generated method stub
		System.out.println("Move left");
		
	}

	@Override
	public void right() {
		// TODO Auto-generated method stub
		System.out.println("Move right");
	}

}
