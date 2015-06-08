package com.xai.timer;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * In order to test AspectJ, you have to compile using a complier that understands aspects
 * to compile: ajc *.java -source 1.6
 *
 */
public class TimerDemo {

	
	// TEST ANYTHING IN HERE
	public static void main(String args []){
		
		//create the instance
		//AspectLogger al = new AspectLogger();
		
		//if successful, you will see these two method run in addition to their own logs
		Timer timer = new Timer();
		timer.methodA();
		timer.methodB();
		
		//timerTest();
		
		
	}
	
	private static void timerTest(){
		Timer timer = new Timer();
		//timer.stopWatchTest(200000);
		//timer.currentTimeTest(200000);
		//timer.nanoTimeTest(200000);
		
		timer.stopWatchTest(5000000);
	}
	
}