package com.xai.patterns.decorator;

import com.xai.patterns.decorator.MyObject.Feature;

public class DecoratorDemo {
	
	public static void main(String [] args){
		
		MyObject dog = ObjectBuilder.get("dog");
		
		((Feet)dog.get(Feature.FEET)).run();
		
	}
	
}
