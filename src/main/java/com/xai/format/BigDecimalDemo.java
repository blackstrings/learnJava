package com.xai.format;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * if you want exact numbers, never use double or float, instead use BigDouble.
 * This is important espeically in money currency and banking.
 * @author xlao
 *
 */
public class BigDecimalDemo {
	
	public static void main(String [] args){
		
		//http://stackoverflow.com/questions/2808535/round-a-double-to-2-decimal-places
		//consider the following examlpe whenusing big decimal
		//so you want to use the string constructor
		System.out.println(new BigDecimal(1.03).subtract(new BigDecimal(0.41)));
		System.out.println(new BigDecimal("1.03").subtract(new BigDecimal("0.41")));
		
		
		//rounding may however doesn't work with big numbers for example
		BigDecimal bd1 = new BigDecimal("98979881.3532");
		BigDecimal bd2 = new BigDecimal("16787678.8232");
		
		BigDecimal bd3 = bd1.add(bd2);
		System.out.println(new BigDecimal(bd3.toString()).setScale(2, RoundingMode.HALF_UP).doubleValue());
	
		//the bigger the double the less accurate it will be in rounding
		System.out.println((98979881.3532d + 16787678.8232d) );
		
		//when going from double to bigDecimal always do this and not BigDecimal(double)
		double d1 = 1.334;
		BigDecimal bd4 = BigDecimal.valueOf(d1);
		
	}

}
