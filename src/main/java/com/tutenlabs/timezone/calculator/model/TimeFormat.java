package com.tutenlabs.timezone.calculator.model;

public class TimeFormat {
	
	private String time;
	private String timezone;
	
	public TimeFormat() {}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getTimezone() {
		return timezone;
	}

	public void setTimezone(String timezone) {
		this.timezone = timezone;
	}

	@Override
	public String toString() {
		return "TimeFormat [time=" + time + ", timezone=" + timezone + "]";
	}
	
	
	

}
