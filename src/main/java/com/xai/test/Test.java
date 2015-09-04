package com.xai.test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;

public class Test {
	
	final static Logger logger = Logger.getLogger(Test.class);

	/**
	 * @param args
	 * @throws Exception
	 */
	public static void main(String [] args) throws Exception{
		
		List<String> list = new ArrayList<String>();
		
		String d;
		try{
		d = list.get(0);
		}catch(IndexOutOfBoundsException ex){
			d = null;
		}
	
		System.out.println(d);
		
		/*
		estimate(24.0);
		estimate(28.0);
		estimate(29.0);
		estimate(40.0);
		estimate(41.0);
		estimate(41.5);
		estimate(41.75);
		estimate(41.95);
		estimate(42.0);
		estimate(44.0);
		estimate(45.0);
		estimate(46.0);
		estimate(54.0);
		estimate(55.0);
		estimate(56.0);
		estimate(57.0);
		estimate(58.0);
		estimate(440.0);
		estimate(441.0);
		estimate(999.0);	//max length per gutter
		*/
		
	}
	
	private static void estimate(double lenInFeet){
		double gutterInFeet = lenInFeet;
		
		//max len we can divde by
		double MaxGutterLen = 28 * 12;
		
		//length
		double gutterLen = gutterInFeet * 12;
		System.out.println("orig length to cover: " + gutterLen + "\" = " + gutterInFeet + " ft");
		
		//how many parts we need dividing by the max - round up
		double qty = Math.ceil(gutterLen / MaxGutterLen); //1, 2, 3, 4 whole numbers
		System.out.println("estimate qty needed: " + qty + " - of 28' or " + (28 * 12) + "in gutters");
		System.out.println("estimated coverage: " + qty * MaxGutterLen + " = " + (qty*MaxGutterLen)/12);
		//sections
		//
		double joints = qty-1;		// 0, 1, 2, 3, whole numbers
		double overlap = joints * 6.0;
		System.out.println("joints: " + joints);
		System.out.println("total overlap to account: " + overlap + " = " + overlap/12 + "ft");
		
		//overlap
		double requiredLength = gutterLen + overlap;
		System.out.println("required length: " + requiredLength + "\" = " + requiredLength/12 + " ft");
		
		//this is for in extreme cases where a gutter length is 1000' plus
		//otherwise the qty will most likely be the same
		qty = Math.ceil(requiredLength / MaxGutterLen);
		System.out.println("new qty: " + qty);
		
		
		//we estimate steel gutters by foot only
		double requiredSteelLength = Math.ceil(requiredLength / qty);
		System.out.println("required steel length per qty: " + requiredSteelLength 
				+ "\" = " + requiredSteelLength/12 + " ft");
		
		double roundUpActualIndividualLength = Math.ceil(requiredSteelLength / 12) * 12;
		
		System.out.println("qty needed: " + qty + " - " 
				+ "each steel length piece round up: " + roundUpActualIndividualLength 
				+ " = " + roundUpActualIndividualLength/12 + " ft");
		
		//total buy length
		double totalBuyLength = (roundUpActualIndividualLength/12) * qty;
		System.out.println("total buy len: " + totalBuyLength + " ft");
		System.out.println("wast: " +  ( totalBuyLength - (requiredLength/12)) + "ft" );
		System.out.println("\n------------------\n");
	}
	
}
