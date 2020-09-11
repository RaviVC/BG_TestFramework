package com.te.qa.log4j;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Log4j_Helper {
	
	public static void main(String[] args) {
		
		Logger logger = LogManager.getLogger(Log4j_Helper.class);
		
		System.out.println("\n Hello World");
		
		logger.info("This is a information message");
		logger.info("This is a error message");
		logger.info("This is a warning message");
		logger.info("This is a fatal message");
	}
}
