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
		
		int sideLength = 8;
		
		for(int row=0; row<sideLength; row++){
			
			for(int col=0; col<sideLength; col++){
				System.out.print("1");
			}
			
			System.out.print("_");
			
			if(row == 0 || row == sideLength-1){
				printFirstLastRow(sideLength);
			}else{
				printMiddle(sideLength);
			}
			
			System.out.println();
			
		}
		
	}
	
	public static void printFirstLastRow(int sideLength){
		for(int i=0; i<sideLength; i++){
			System.out.print("2");
		}
	}
	
	public static void printMiddle(int sideLength){
		for(int i=0; i<sideLength; i++){
			
			if(i==0 || i== sideLength-1){
				System.out.print("3");
			}else{
				System.out.print("0");
			}
	
		}
	}
	
	
	
}
