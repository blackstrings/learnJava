package com.xai.primitiveTypes;

/**
 * String is immutable meaning it cannot be changed once created. You may not realize, but when you modify a string,
 * what happens is that a new string is created and return.
 * @author xlao
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
