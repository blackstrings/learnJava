package com.xai.dataStructure;

import java.util.EnumMap;
import java.util.Map;

/**
 * EnumMap is similar to HashMap but can only store enums as key.
 * Due to how enumMap is optimize, if you plan to use enums as key, it is best to use
 * the enum map as it is faster.
 * 
 * <p>
 * One is because enumMap doesn't call hashCode methods on key, there is no chance of collision.
 * Since Enum is internally maintain as array and they are stored in there natural order 
 * using ordinal()
 * </p>
 * @author xlao
 *
 */
public class EnumMapDemo {

	public enum FishType {
		BASS, WALLEYE, BLUE_GILL;
	}
	
	public static void main(String [] args){
		
		Map<FishType, String> eMap = new EnumMap<FishType, String>(FishType.class);
		
		eMap.put(FishType.BASS, "Very Big Fish");
		
		System.out.println(eMap.get(FishType.BASS));
		
	}
	
}
