package com.xai.dataStructure;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import org.springframework.util.StopWatch;

/**
 * <p>
 * Better than hashTable, stores key and value, sorted, faster, calls store values by key.
 * - roughtly similar to hashTable
 * - In Big O notation, hashMap is 1 to 1 ratio.
 * - does not guarantee the order of the map will stay constant over time
 * - hashMap iterator is fail-fast (not fail-safe) where hashTable isn't
 * - fail-fast means the fail behaviour during concurrent modifcation is guarantee
 * </p>
 * 
 * <p>
 * However hashMap is not synchronize, where hashTable is
 * Synchronize means only one thread can modify the hashTable at any given time.
 * There will be a lock on the table obj, while objects wait for the lock to be released
 * to synchronize hashmap do Map m = Collections.synchronizedMap(myHashMap) for synchronization
 * </p>
 * </p>
 * @author xlao
 *
 */
public class HashMapDemo {

	//<key type, value type>
	
	public void HashMapSample(){}
	
	public static void main(String [] args){
		
		HashMapDemo hashMapSample= new HashMapDemo();
		
		//type <String, Integer>
		Map<String, Integer> hm = new HashMap<String, Integer>();
		
		//stopwatch
		StopWatch sw = new StopWatch();
		sw.start();
		
		//insert (key, value)
		//populate hm
		for(int i=0; i<10000; i++){
			hm.put(i+"", i);
		}
		
		sw.stop();
		System.out.println("Took " + sw.getTotalTimeSeconds() + " seconds to populate");
		
		//check hasmap
		System.out.println( hm.containsKey("1"));	// check key exist
		System.out.println( hm.containsValue(5));		// check value exist
		System.out.println( hm.get("1"));			// get value by key

		//to read all keys and values in hashmap
		/*
		for(String name: hm.keySet()){	//return all keys
			String key = name.toString();
			String val = hm.get(name).toString();
			System.out.println(key + " " + val);
		}
		*/

		
		
	}
	
}
