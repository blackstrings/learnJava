package com.xai.utils;

import java.util.HashMap;

import org.apache.log4j.Logger;


public class Utils {
	
	public void Utils(){
		
	}
	
	public int addFour(int num){
		return num+4;
	}
	
	private static final Logger logger = Logger.getLogger(Utils.class);
	/**
	 * @param args
	 */
	public static void main(String [] args){
		//logger.info("" + Math.random());

		System.out.println( convertScaledValueToDegree(.2f, 0, 100) );
		
		
		
	}
	
	private static void pass(int[] nums){
		int[] nums2 = nums;
		for(int i=0; i<nums2.length; i++){
			nums2[i] = 0;
		}
		
	}
	
	private static float convertScaledValueToDegree(float scaledValue, int min, int max){
		
		float convertVal = scaledValue * max;	//.5 will equal half of max
		return convertVal;
	}
	
	
}
