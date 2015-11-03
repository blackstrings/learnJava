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
		logger.info("" + Math.random());


		int[] nums = new int[]{1,2,3,4,5};
		
		pass(nums);
		for(int num : nums){
			System.out.println(num);
		}
		
	}
	
	private static void pass(int[] nums){
		int[] nums2 = nums;
		for(int i=0; i<nums2.length; i++){
			nums2[i] = 0;
		}
		
	}
	
	
}
