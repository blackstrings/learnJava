package com.xai.utils;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.apache.log4j.Logger;

//
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

		//System.out.println( convertScaledValueToDegree(.2f, 0, 100) );
		
		int count = 0;
		for(int i=0; i<3; i++){
			for(int k=0; k<3; k++){
				count++;
				
			}
			
			if(true){
				break;
			}
		}
		
		System.out.println(count);
		
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
	
	public static double randomBetweenTwoDouble(double min, double max){
		double offset = max-min;
		double random = min + Math.ceil( (Math.random()*offset));
		return formatDouble(random);
	}
	//to pretty format your number
	public static double formatDouble(double num){
		DecimalFormat df = new DecimalFormat("#0.00");
		return Double.valueOf(df.format(num));
	}
	
	
}
