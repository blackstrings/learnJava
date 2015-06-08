package com.xai.gametest2;

import java.util.HashMap;
import java.util.Map;

/**
 * This class is not used, but has mapping to different values
 * @author laox
 *
 */
public enum nType {
	STANDARD(0, "standard"), 
	AMATEUR(1, "amateur"), 
	PRO(2, "pro"),
	CUSTOM(3, "custom");
	
	private int code;
	private String name;
	private static Map<Integer, String> map;
	
	nType(int code, String name){
		this.code = code;
		this.name = name;
	}
	private int code(){return code;}
	
	//can't do name variable so have to go through a hashmap
	private String getName(){return name;}
	
	public String getType(int i){
		if(map == null){
			// create map
			map = new HashMap<Integer, String>();
			
			// populate map
			for(nType type : values()){
				map.put(type.code, type.name);
			}
			
		}
		return map.get(i);
	}
	
}
