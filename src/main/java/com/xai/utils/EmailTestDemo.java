package com.xai.utils;

import org.apache.commons.math3.util.Precision;


public class EmailTestDemo {

	public static void main(String [] args){

		double n1 = 3.0;
		double n2 = 2.99;
		
		System.out.println(Precision.equals(n1, n2, 5));
		
	}
	

}
