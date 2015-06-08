package com.xai.format;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;

public class DoubleDemo {
	
	public static void main(String [] args){
		
		//Double random = Math.random()*20.35343;
		Double random = 9.223372036854776;
		
		//method 1
		String t1 = String.format("%.2f", random);
		
		//method 2
		DecimalFormat df = new DecimalFormat("####0.00");
		double t2 = random;
		t2 = Double.valueOf(df.format(random));
		
		//method 3 with bigDecimal if you need exact
		double t3 = new BigDecimal(random.toString()).setScale(2,RoundingMode.HALF_UP).doubleValue();
		
		
		//rounding decimals to places
		//http://stackoverflow.com/questions/2808535/round-a-double-to-2-decimal-places
		System.out.println(t1);
		System.out.println(t2);
		System.out.println(t3);
		
		
		
	}
	
}
