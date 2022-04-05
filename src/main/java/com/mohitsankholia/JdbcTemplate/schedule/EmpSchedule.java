package com.mohitsankholia.JdbcTemplate.schedule;

import java.util.Date;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class EmpSchedule {
	
	private static Logger LOGGER = LogManager.getLogger(EmpSchedule.class);

	@Scheduled(fixedRate=2000)
	void printTime() {
		
//		System.out.println("Time is "+ new Date());
		LOGGER.info("Time is "+ new Date());
	}
	
	@Scheduled(fixedRate=2000)
	void printTimeAgain() {
		
//		System.out.println("Time is "+ new Date());
		LOGGER.info("Time is again"+ new Date());
	}
}
