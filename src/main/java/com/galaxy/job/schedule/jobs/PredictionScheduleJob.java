package com.galaxy.job.schedule.jobs;

import org.quartz.Job;
import org.quartz.JobDetail;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.SimpleTrigger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.quartz.JobDetailFactoryBean;
import org.springframework.scheduling.quartz.SimpleTriggerFactoryBean;
import org.springframework.stereotype.Component;

import com.galaxy.job.schedule.services.IPredictionService;

@Component
public class PredictionScheduleJob implements Job {

	@Autowired
	private IPredictionService predictionService;
	
	public void execute(JobExecutionContext context) throws JobExecutionException {
        predictionService.prediceWeather();
    }
	
	@Bean
	public JobDetailFactoryBean jobDetail() {
		JobDetailFactoryBean jobDetailFactory = new JobDetailFactoryBean();
		jobDetailFactory.setJobClass(PredictionScheduleJob.class);
		jobDetailFactory.setDescription("Invoke prediction job ...");
		jobDetailFactory.setDurability(true);
		return jobDetailFactory;
	}
	
	@Bean
	public SimpleTriggerFactoryBean trigger(JobDetail job) {
	    SimpleTriggerFactoryBean trigger = new SimpleTriggerFactoryBean();
	    trigger.setJobDetail(job);
	    trigger.setRepeatInterval(1000);
	    trigger.setRepeatCount(SimpleTrigger.REPEAT_INDEFINITELY);
	    return trigger;
	}
}

