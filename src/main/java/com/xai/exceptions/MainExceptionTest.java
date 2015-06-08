package com.xai.exceptions;

import com.xai.oopTest1.Troll;

/*
 * Try not to create new custom exceptions if they do not have useful information for client code.
 * Instead use the runtimeexception that'a alrady avaialable in Java.
 * Having too many exceptions can slow down your program
 */

public class MainExceptionTest {
	
	public MainExceptionTest(){}
	
	public static void main(String [] args) throws InvalidNameException{
		
		/*
		 * A new class that has its own method that will handle and throw it's own excpetion 
		 */
		Troll troll = new Troll(5, "Timmy");			// constructor handles an exception so no need to use try cause cases here
		
		//this will throw invalidName exception
		troll.setName("Troll");							// class method handles exception so no need to use try cause cases here
		
		System.out.println("My name is " + troll.getName() );
		
		
		/* 
		 * Another way to force throw exception
		 * Note when throwing custom exception, you must put it inside try/catch clause, except for pre-built java exceptions
		 */
		/*
		try{
			throw new InvalidNameException("NoMore");
		}catch(InvalidNameException e){
			e.printStackTrace();
		}
		*/
		
		
		/*
		 * Throwing regular java exceptions
		 * you do not need to put inside try catch causes
		 */
		//throw new IllegalArgumentException("Illegal use of names");
		
	}
	
}
