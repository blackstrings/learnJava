package com.xai.strings;

//Starting are the most common string methods going to least used string methods
public class StringDemo1 {

	public static void main(String [] args){
		
		//substring
		//[I][ ][a][m][ ][g][o][o][d]
		// 0  1  2  3  4  5  5  7  8
		String str = "I am good.";
		// gets char at index 0 all the way to index 4,
		// but excludes character at index 4, so really you get char at indexes 0-3
		str = str.substring(0, 4);	
		print(str);	//	prints "I am"
		
		//removing leading characters in string
		str = "000233";
		str = str.replaceFirst("^0+(?!$)", "");
		print(str);	// prints "233"
		
		//replacing characters in string
		str = "aabbccaa";
		str = str.replace('a', 'k');
		print(str);	//prints "kkbbcckk"
		
		//split example 1
		//splits returns a string array not a single string - important to know this
		str = "super.man";
		// if you are using a dot, you have to use the escape \\ symbol
		// in front of the dot as . is a special java symbol
		// so what you are really searching for is \.
		// but since \ is also a used symbol we have to escape that too
		// so you get \\ followed by a .
		String[] strArr = str.split("\\.");	
		print(strArr[0]);	//	//prints super
		
		//split example 2
		str = "super man";
		str = str.split(" ")[0];	//grab the index 0 rightaway from the array return and pass it to str
		print(str); 	// prints super
	}
	
	private static void print(String str){
		System.out.println(str);
	}
	
}


