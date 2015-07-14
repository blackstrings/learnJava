package com.xai.reflection;

import java.lang.reflect.Method;

/**
 * Reflection is simply for the purpose of being able to 
 * read a class obj's attributes, methods, etc, 
 * before initializing it. In other words, using reflection it makes it
 * possible for one to see in advance if
 * a certain class has a specific method or attribute before deciding to
 * actually instantiate the class.
 * 
 * This is used a lot in the Junit testing and annotations.
 *
 */
public class ReflectionDemo {

	public static void main(String [] args){
		
		//get the class
		Class<MyReflectionClass> obj = MyReflectionClass.class;
		
		//get the class methods
		Method[] methods = obj.getMethods();
		
		//iterate through the names
		for(Method method : methods){
			System.out.println(method.getName());
		}
	}
	
}
