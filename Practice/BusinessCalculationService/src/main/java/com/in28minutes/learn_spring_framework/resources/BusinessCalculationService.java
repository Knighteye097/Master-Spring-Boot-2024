package com.in28minutes.learn_spring_framework.resources;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class BusinessCalculationService {
	
	private DataService dataService;
	
	public BusinessCalculationService(@Qualifier("mongoDbDataService") DataService dataService) {
		super();
		this.dataService = dataService;
	}

	public int findMax() {
		return Arrays.stream(this.dataService.retrieveData()).max().orElse(0);
	}
}
