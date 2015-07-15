package com.xai.primitiveTypes;

/**
 * String is immutable meaning it cannot be changed once created. You may not realize, but when you modify a string,
 * what happens is that a new string is created and return.
 * 
 * For one or two simple concat, the string += is okay
 * but once the string is big and multiple += are needed, performance will be an issue
 * therefore use the StringBuffer (sychronized) instead
 * 
 * if not logging and no synchronize is needed or on single thread, 
 * use stringBuilder for faster performance
 *
 *
 */
public class StringDemo {

	public static void main(String [] args){

		String str = "";
		
		if(str == null){
			System.out.println("Str is null");	//will not happen because string is not null but is empty
		
		//check when empty instead
		}else if(str.isEmpty()){
			System.out.println("is empty");
		}
		
	}
	
}
