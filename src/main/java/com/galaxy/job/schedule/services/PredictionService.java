package com.galaxy.job.schedule.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.galaxy.job.schedule.repository.IPredictionRespository;


@Component
public class PredictionService implements IPredictionService {

	private Logger logger = LoggerFactory.getLogger(PredictionService.class);
	
	@Autowired
	private IPredictionRespository predictionRepository;
	
	@Value("${galaxy.schedule.startday}")
	private int configStartDay;
	
	
	@Value("${galaxy.schedule.range}")
	private int configRange;
	
	private int startDay;
	private int endDay;
	
	public PredictionService() {
		super();
		startDay = configStartDay;
		endDay =configRange;
	}

	@Override
	public void prediceWeather() {
		logger.info("Job execution...calculate weather prediction");
		predictionRepository.weatherPrediction(startDay, endDay);
		startDay += endDay + 1;
		endDay = startDay + configRange; 
		
	}
	
	
}
