package com.xai.oopTest1;

import org.apache.log4j.Logger;

import com.xai.exceptions.*;

public class Troll extends Enemy {
	String[] invalidNames = {"troll", "trolls"};
	
	final static Logger logger = Logger.getLogger(Troll.class);
	
	public Troll(int hp, String name) {
		super(hp, name);
		validateName(name); 
	}
	
	/*
	 * Exception test
	 * if you throw an exception without a try catch, you have to use the throws exception
	 * by the method signature
	 * It is best to use a try catch to throw an exception at the initial exception point
	 * like for example here so you don't have to keep throwing the exception beyond this class
	 */
	public void validateName(String name) {
		for(String invalidName : invalidNames){
			if(name.compareToIgnoreCase(invalidName) == 0 ){		// returns 0 if same
				try {
					throw new InvalidNameException(name);
				} catch (InvalidNameException e) {
					logger.error("Invalid Naming!", e);
					//e.printStackTrace();
				}
			}
		}
	}
	
	/*
	 * setter
	 */
	@Override
	public void setName(String n){
		validateName(n);
		super.setName(n);
	}
	
	public String toString(){
		String str = super.toString();
		return str + "Troll";
	}
	
}
