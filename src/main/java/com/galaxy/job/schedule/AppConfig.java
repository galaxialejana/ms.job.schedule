package com.galaxy.job.schedule;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.galaxy.job.schedule.services.IPredictionService;
import com.galaxy.job.schedule.services.PredictionService;

@Configuration
public class AppConfig {

    @Bean
    public IPredictionService transferService() {
        return new PredictionService();
    }
}
