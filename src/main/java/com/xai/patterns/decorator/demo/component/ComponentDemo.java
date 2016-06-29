package com.xai.patterns.decorator.demo.component;

import com.xai.patterns.decorator.demo.component.BaseObject.FeatureType;

public class ComponentDemo {
	
	/**
	 * The main idea behind a decorator, is that an object can be evolved/decorated
	 * to have more features by adding other classes to it.
	 * 
	 * In this example, MyObject is simple an entity without it's full features
	 * Once we add eyes and legs to the MyObject, it starts to become like a dog
	 * It can see and can run.
	 * 
	 * There are many ways, but we are utilizing enums to get the correct return type.
	 * @param args
	 */
	public static void main(String [] args){
		
		BaseObject dog = ObjectBuilder.get(EntityType.DOG);
		
		dog.get(FeatureType.FEET).action();
		dog.get(FeatureType.EYE).action();
		//((Eye)dog.get(Feature.EYE)).look();
		
	}
	
}