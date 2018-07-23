package com.galaxy.job.schedule;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import com.galaxy.job.schedule.repository.IPredictionRespository;
import com.galaxy.job.schedule.repository.PredictionRepository;
import com.galaxy.job.schedule.services.IPredictionService;
import com.galaxy.job.schedule.services.PredictionService;

@Configuration
public class AppConfig {

	
    @Bean
    public IPredictionService transferService() {
        return new PredictionService();
    }
    
    @Bean
    public IPredictionRespository predictionRepository() {
    	return new PredictionRepository();
    }
    
	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}
}
