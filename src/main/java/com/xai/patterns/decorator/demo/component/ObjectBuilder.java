package com.xai.patterns.decorator.demo.component;

import com.xai.patterns.decorator.demo.component.BaseObject.FeatureType;

public class ObjectBuilder {

	public static BaseObject get(EntityType type){
		if(type == EntityType.DOG){
			BaseObject bo = new BaseObject();
			bo.addFeature(FeatureType.FEET, new Feet());
			bo.addFeature(FeatureType.EYE, new Eye());
			return bo;
		}
		
		return null;
	}
	
}
