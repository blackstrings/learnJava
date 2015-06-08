package com.xai.exceptions;

/*
 * Exception Class
 * When you want to require a method to catch exceptions
 * simply write "throws DuplicateNameException" after the method signature ()
 * ex: public void add(String name) throws DuplicateNameExcpetion { ... }
 * 
 * Exception classes are just like any regular class that can have methods and fields
 * - usually an exception class should have fields to store the data and
 * methods to return that stored data so it can
 * inform the user what data caused the exception to be thrown
 * 
 * There are checked and unchecked exceptions. Checked are ones that the client can fix
 * on their side. Uncheck is something that the client cannot fix such as runtime errors.
 */

import java.util.ArrayList;

// checked exception must extend the Exception class
// uncheck exception must extend the RuntimeException class
public class DuplicateNameException extends Exception {

	private String name;
	private ArrayList<String> names;
	
	/*
	 * Constructor
	 */
	public DuplicateNameException(){
		
	}
	
	public DuplicateNameException(String name){
		names = new ArrayList<String>();
		this.name = name;
		names.add(this.name);
		
		// convert exception into a runtime exception so you can see stack trace
			//throw new RuntimeException();
		
		// further throw other exception if you want
		//throw run time exception if you want to catch the stack trace
		/*
		for(String n : names){
			if(this.name.equals(n)){
				throw new RuntimeException();
			}
		}
		*/
	}
	
	public String requestName(){
		return name;
	}
	
	public ArrayList<String> availabeNames(){
		return names;
	}
	
	public String toString(){
		String str = super.toString();
		return str + " > " + requestName() + " is a duplicated name";
	}
	
}
