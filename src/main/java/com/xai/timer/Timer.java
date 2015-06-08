package com.xai.timer;


import org.springframework.util.StopWatch;

/**
 * The spring StopWatch is probably the best to use as it has all the conversions implemented for you.
 * @author xlao
 *
 */
public class Timer {
	
	private long startTime = System.nanoTime();
	private long endTime = System.nanoTime();
	public StopWatch stopWatch;
	
	public Timer(){
		
	}
	
	/**
	 * <p>Using System.nano time. Currently faster than CurrentTimeMillis().
	 * </p>
	 * @param delayTime
	 */
	public void nanoTimeTest(long delayTime){
		startTime = System.nanoTime();
		
		//process
		testProcess(delayTime);
		
		endTime = System.nanoTime();
		
		System.out.println("Using nano time \n" +
							"Total Time: " + ((endTime - startTime)/1000000 * .001));
		
	}
	
	/**
	 * Using System.current time which has a longer processing time
	 * @param delayTime
	 */
	public void currentTimeTest(long delayTime){
		startTime = System.currentTimeMillis();
		
		//process
		testProcess(delayTime);
		
		endTime = System.currentTimeMillis();
		
		System.out.println("Using Current Time Millis \n" +
							"Total Time: " + ((endTime - startTime) * .001));
		
	}
	
	/**
	 * Using spring framework.stop watch
	 * You don't have to do milli to second conversion.
	 * @param delayTime
	 */
	public void stopWatchTest(long delayTime){
		
		stopWatch = new StopWatch();
		stopWatch.start();
		
		//process
		testProcess(delayTime);
				
		stopWatch.stop();
		
		System.out.println("Using stopWatch \n" +
				"Total Time: " + stopWatch.getTotalTimeSeconds() );
	}
	
	//helper methods
	public void methodA(){
		System.out.println("MethodA");
	}
	
	public void methodB(){
		System.out.println("MethodB");
	}
	
	public void testProcess(long delayTime){
		// process
		//-------------------------------------
		String str;
		
		for(int i=0; i<delayTime; i++){
			str = ""+i;
		}
		//--------------------------------------
	}

	
}