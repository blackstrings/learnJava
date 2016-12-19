package com.xai.patterns.decorator.demo.component;

import java.util.EnumMap;
import java.util.Map;

public class BaseObject {
	
	enum FeatureType{
		EYE, NOSE, FEET
	}
	
	Map<FeatureType, Feature> objects = new EnumMap<FeatureType, Feature>(FeatureType.class);
	
	public BaseObject(){
		
	}
	
	void addFeature(FeatureType feature, Feature obj){
		objects.put(feature, obj);
	}
	
	public Feature get(FeatureType featureType){
		if(objects.containsKey(featureType)){
			return objects.get(featureType);
		}
		return null;
	}
	
}
