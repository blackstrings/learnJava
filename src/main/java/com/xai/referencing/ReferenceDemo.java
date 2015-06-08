package com.xai.referencing;

import com.xai.objects.Cat;

/**
 * Example showing that java passes arguments by value, not reference
 * @author xlao
 *
 */
public class ReferenceDemo {
	
	public static void main(String [] args){
		
		Cat d1 = new Cat("Tom", 1L);
		assignNewDog(d1);
		
		//java pass by value, not pass by reference
		if(d1.getName().equals("Tom")){
			System.out.println("Assigning new obj did not changed old obj name");	//true
		}
		
		changeDogName(d1);
		if(d1.getName().equals("Tom")){
			System.out.println("the dog name has not changed");
		}else{
			System.out.println("Changing the dog name by method has changed the dog name");
		}
		
		//if by reference, then the above statement would return false,
		//as the dog would now have a new name of Mike
		
		String str1 = "String1";
		modifyString(str1);
		if(str1.equals("String1")){
			System.out.println("the string was not changed");
		}
		
	}
	
	private static void assignNewDog(Cat d){
		d = new Cat("Mike", 1L);
	}
	
	private static void changeDogName(Cat d){
		d.setName("new name");
	}
	
	private static void modifyString(String str){
		str = "String2";
	}
}
