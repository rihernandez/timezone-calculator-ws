package com.tutenlabs.timezone.calculator.controller;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.HashMap;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tutenlabs.timezone.calculator.model.TimeFormat;

@RestController
@RequestMapping("/api/v1")
public class TimeZoneCalculator {
	
	private int zone;
	private String hour;
	private String clockwise;
	
	
	@GetMapping("/current-datetime")
	public String getCurrentTime() {
		
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss z");
		Date date = new Date(System.currentTimeMillis());
		
		return formatter.format(date).toString();
	}
	
	
	
	@PostMapping("/time-zone")
	public ResponseEntity<?> getCalculateTime(@RequestBody TimeFormat data) {
		
		
		hour = data.getTime();
		clockwise = String.valueOf(data.getTimezone().charAt(0));
		zone = Integer.parseInt(data.getTimezone().substring(1));
		
		if ( clockwise.equals("-")) {
			
			data.setTime(this.buildNewUTC(this.substractTimeZone(hour)));
	
		}else if ( clockwise.equals("+")) {
			
			data.setTime(this.buildNewUTC(this.sumTimeZone(hour)));
			
		} 
	
	    //System.out.println(hour);
	    
	    HashMap<String, Object> map = new HashMap<String, Object>();
	    map.put("response", data);

		return ResponseEntity.ok(map);
		
	}
	
	
	
	public String getFirstHourDigit(String hour) {
		
		String[] hourDigits = hour.split(":");
		
		System.out.println(hour);
		System.out.println(hourDigits[0]);
		int firstDigit = Integer.parseInt(hourDigits[0]);
		
		return Integer.toString(firstDigit);
	}
	
	
	public String buildNewUTC(String firstDigit) {
		
	    String first = firstDigit;
	    
	    String[] hourDigits = hour.split(":");
	    
	    hour = first+":"+hourDigits[1]+":"+hourDigits[2];
	    
		return  hour;
	}
	
	
	
	public String sumTimeZone(String hour) {
		
		String digit = this.getFirstHourDigit(hour);
		int newDigit = Integer.parseInt(digit) + zone;
		
		return Integer.toString(newDigit);	
		
	}
	
	public String substractTimeZone(String hour) {
		
		String digit = this.getFirstHourDigit(hour);
		int newDigit = Integer.parseInt(digit) - zone;
		
		return Integer.toString(newDigit);	

	}
	
	
	
	

}
