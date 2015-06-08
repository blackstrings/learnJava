package com.xai.nesting;

/**
 * Example of nesting class. Highly discourage to use nesting for serialization.
 * @author xlao
 *
 */
public class OutterClass {

	//notice nesting class is implemented without the ()
	
	class NonStaticClass {
		public int depth = 5;
	}
	
	static class StaticNestClass{
		public int depth = 10;
	}
	
	public static void main(String [] args){
		
		//create the parent
		OutterClass outterClass = new OutterClass();
		
		//create the static nested class
		OutterClass.StaticNestClass sn = new OutterClass.StaticNestClass();
		
		//create the non-static nested class
		OutterClass.NonStaticClass ns = outterClass.new NonStaticClass();
		
		sn.depth = 11;
		ns.depth = 10;
		
		System.out.println(sn.depth);
		System.out.println(ns.depth);
		
	}
	
}
