package com.xai.patterns.decorator;

import com.xai.patterns.decorator.MyObject.Feature;

public class ObjectBuilder {

	public static MyObject get(String type){
		if(type.equals("dog")){
			MyObject dog = new MyObject();
			
			dog.addFeature(Feature.FEET, new Feet());
			dog.addFeature(Feature.EYE, new Eye());
			return dog;
		}
		
		return null;
	}
	
}
