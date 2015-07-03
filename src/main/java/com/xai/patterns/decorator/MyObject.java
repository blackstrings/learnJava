package com.xai.patterns.decorator;

import java.util.EnumMap;
import java.util.Map;

public class MyObject {
	
	public enum Feature{
		FEET, EYE
	}
	
	Map<Feature, Object> objects = new EnumMap<Feature, Object>(Feature.class);
	
	public MyObject(){
		
	}
	
	void addFeature(Feature feature, Object obj){
		objects.put(feature, obj);
	}
	
	public Object get(Feature feature){
		if(objects.containsKey(feature)){
			return objects.get(feature);
		}
		return null;
	}
	
}
