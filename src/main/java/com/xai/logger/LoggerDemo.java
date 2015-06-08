package com.xai.logger;

import org.apache.log4j.Logger;

/**
 * Demonstrates how to use the log4j. Where the log file is logged to
 * depends on the setting set in the resources/log4j.properties.
 * If the log file does not exist, a new log file will be created in its place.
 * If the log file reaches the max capacity, a new file will auto generate leaving
 * the old log file appeneded with a number.
 * @author xlao
 *
 */
public class LoggerDemo {
	
	//to use the log4j logger
	final static Logger logger = Logger.getLogger(LoggerDemo.class);
	
	public LoggerDemo(){
		//to call it, this simple line will document where the log was called from and what class
		//the warn and error are most commonly used
		logger.warn("I'm alive");
	}
	
	
	public static void main(String [] args){
		
		LoggerDemo logDemo = new LoggerDemo();
		
	}
}
