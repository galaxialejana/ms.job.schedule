package com.galaxy.job.schedule.repository;

public class PredictionPeriod {
	private int startDay;
	private int endDay;
	
	public PredictionPeriod() {
		super();
	}

	public PredictionPeriod(int startDay, int endDay) {
		super();
		this.startDay = startDay;
		this.endDay = endDay;
	}

	public int getStartDay() {
		return startDay;
	}

	public void setStartDay(int startDay) {
		this.startDay = startDay;
	}

	public int getEndDay() {
		return endDay;
	}

	public void setEndDay(int endDay) {
		this.endDay = endDay;
	}
}
