package com.xai.operators;

/**
 * <p>
 * The modular operator is use to tell if a number will have any remaining left.
 * </p>
 * <p>
 * Some examples:
 * <br>
 * 6 % 2 = 3.0, with zero remaining. So modular returns 0
 * <br>
 * 6.5 % 2 = 3.0, with 0.5 remaining. So modular returns .5
 * </p>
 * <p>
 * In other words 6 can be divided by 2 three times as a whole number, then what ever remains,
 * the modular returns that.
 * 
 * </p>
 * @author xlao
 *
 */
public class modular {

	public static void main(String [] args){
		
		double x = 7.0;
		double y = 2.0;
		
		System.out.println(x % y);
		
	}
	
}
