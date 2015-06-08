package com.xai.dataStructure;

import java.util.Hashtable;
import java.util.Map;

/**
 * <p>
 * Hashtable are syncrhonized maps so they are good for multi-threaded applications.
 * If you are not in a multi-threaded application, use hashMap instead as it performs better.
 * </p>
 * <p>
 * Does not permits null values and keys
 * </p>
 * @author xlao
 *
 */
public class HashTableDemo {
	
	public static void main(String [] args){
		Map<String, Integer> map = new Hashtable<String, Integer>();
		map.put("age", 55);
		
		System.out.println( map.get("age"));
		
	}
	
}
