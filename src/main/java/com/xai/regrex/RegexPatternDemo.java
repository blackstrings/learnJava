package com.xai.regrex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexPatternDemo {

	public static void main(String [] args){
		
		if(validateNumeric("8"))
				System.out.println("yes");
		
		
	}
	
	private static boolean validateNumeric(String value){
		Pattern pattern = Pattern.compile("['0-9']");
		CharSequence result = value.subSequence(0, 1);
		Matcher matcher = pattern.matcher(result);		
		return matcher.matches();
	}
}
