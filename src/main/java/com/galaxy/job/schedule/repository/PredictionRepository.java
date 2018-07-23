package com.galaxy.job.schedule.repository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.client.RestTemplate;


public class PredictionRepository implements IPredictionRespository {

	private Logger logger = LoggerFactory.getLogger(PredictionRepository.class);
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Value("${galaxy.weatherservice.server}")
	private String weatherServiceServer = "";
	

	private String resourcePredictName = "predictweather";
	
	
	@Override
	public void weatherPrediction(int startDay, int endDay) {
		
		String uri = weatherServiceServer + "/" + resourcePredictName;
		try {
			
			restTemplate.postForEntity(uri, new PredictionPeriod(startDay, endDay), String.class);
			
		} catch (Exception e) {
			logger.error(e.toString());
		}
		
		
	}

}
