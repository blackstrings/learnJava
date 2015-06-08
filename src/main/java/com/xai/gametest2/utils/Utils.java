package com.xai.gametest2.utils;

import java.text.DecimalFormat;

public class Utils {
	public static enum Type{
		STANDARD, AMATEUR, PRO, CUSTOM;
	}
	public static enum Xml {
		ITEM, CHARACTER;
	}
	
	public static String formatStrToUpperCase(String format){
		StringBuilder sb = new StringBuilder();
		sb.append(format.substring(0, 1).toUpperCase());
		sb.append( format.substring(1, format.length()).toLowerCase() );
		return sb.toString();
	}
	
	/**
	 * The offset between min and max is the key in getting the inbetween value
	 * @param min
	 * @param max
	 * @return
	 */
	public static double randomBetweenTwoDouble(double min, double max){
		double offset = max-min;
		double random = min + Math.ceil( (Math.random()*offset));
		return formatDouble(random);
	}
	
	public static double formatDouble(double num){
		DecimalFormat df = new DecimalFormat("#0.00");
		return Double.valueOf(df.format(num));
	}
}
