package com.xai.dataStructure;

import java.util.EnumMap;
import java.util.HashMap;
import java.util.Map;

import com.xai.enumeration.Prop;

public class HashMapManyTypeDemo {
	
	private static Map<Prop, Object> mapEnumType;
	
	public static void main(String [] args){
		
		//hash key by string
		Map<String, Object> mapStr = new HashMap<String, Object>();
		mapStr.put(Prop.HEIGHT.name(), 5.5);
		mapStr.put(Prop.NAME.name(), "Tommy");
		System.out.println(mapStr.get(Prop.NAME.name()) + " : " + mapStr.get("hp"));
		
		//hash key by any enum
		Map<Enum, Object> mapEnum = new HashMap<Enum, Object>();
		mapEnum.put(Prop.AGE, 100);
		mapEnum.put(Prop.HEIGHT, 5.5);
		
		//hash key by specific enum type, to do this, use an enumMap
		//best performance when using enumMap
		mapEnumType = new EnumMap<Prop, Object>(Prop.class);
		mapEnumType.put(Prop.AGE, 50);
		mapEnumType.put(Prop.NAME, "Tim");
		System.out.println(mapEnumType.get(Prop.AGE));
		
		//the getProp method will handle its proper return type
		String name = getProp(Prop.NAME);
		name += "TEST";
		System.out.println(name);
		
		Integer age = getProp(Prop.AGE);
		age += 10;
		System.out.println(age);
		
	}
	
	//how to get the correct cast by just calling for the key
	/**
	 * Allows generic type returns
	 * each return type will need to be handled and casted properly
	 * @param prop
	 * @return
	 */
	private static <E> E getProp(Prop prop){
		Object result = mapEnumType.get(prop);
		
		//longer way
		if(result instanceof Boolean){
			Boolean val = (Boolean) result;
			return (E) val;
		}
		//short way
		if(result instanceof String){ return (E) (String) result; }
		if(result instanceof Integer){ return (E) (Integer) result; }
		if(result instanceof Double){ return (E) (Double) result; }
		
		return null;	//the stored type is not yet implemented in here
	}
	
	
}
