package com.in28minutes.learn_spring_framework.resources;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class MySQLDataService implements DataService{

	@Override
	public int[] retrieveData() {
		// TODO Auto-generated method stub
		return new int[] {1 , 2, 3, 4, 5};
	}

}
