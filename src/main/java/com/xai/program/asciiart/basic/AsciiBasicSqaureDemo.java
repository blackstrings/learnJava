package com.xai.program.asciiart.basic;

public class AsciiBasicSqaureDemo {

	/**
	 * Prints rows and cols according to the number
	 * @param args
	 */
	public static void main(String [] args){
		

		int sideLength = 6;
		
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
