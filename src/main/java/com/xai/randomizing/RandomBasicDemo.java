package com.xai.randomizing;

import java.text.DecimalFormat;
import java.util.Random;

public class RandomBasicDemo {

	public static void main(String[] args){
		
		//double
		double rand0 = Math.random(); //generate between 0-1;
		System.out.println("rand0: " + rand0);
		
		//get random between 0 and X
		double rand1 = Math.random()*10;
		System.out.println("rand1: " + rand1);
		
		//get random between Min and Max
		//longer to implement but easier to read
		double rand2 = randomBetweenTwoDouble(5, 10);
		System.out.println("rand2: " + rand2);
		
		//using the Random class to get a int
		Random random = new Random();
		double rand3 = random.nextInt(5) + 3;	//between 3 - 8
		System.out.println("rand3: " + rand3);
		
		//using the Random class to get between Min and Max
		//simpler to implimement but harder to read
		//formula: to get random between min and max
		// random.nextInt(max-min) + min
		// max-min is pretty much the offset
		random = new Random();
		double rand4 = random.nextInt(5) + 3;	//between 3 - 8
		System.out.println("rand4: " + rand4);
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
