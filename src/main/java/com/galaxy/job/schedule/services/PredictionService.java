package com.galaxy.job.schedule.services;

import org.springframework.stereotype.Component;

@Component
public class PredictionService implements IPredictionService {

	public PredictionService() {
		
	}

	@Override
	public void prediceWeather() {
		System.out.println("Job....");
	}
	
	
}
