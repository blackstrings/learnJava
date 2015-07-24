package com.xai.dataStructure;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
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
		
		HashMap<String, String> hm2 = new HashMap<String, String>();
		hm2.put("item", "ball");
		
		//if the first check is fale, the 2nd check will not run
		if(hm2.containsKey("items") && hm2.get("items").equals("ball")){
			System.out.println("same");
		}else{
			System.out.println("no errors");
		}
		
		
		//iterate hashmap for keys only
		List<String> ids = new ArrayList<String>();
		for(String str : hm2.keySet()){
			ids.add(str);
		}
		
		//values only
		for(String str : hm2.values()){
			
		}
		
		//both key and value
		for(Map.Entry<String, String> entry : hm2.entrySet()){
			String key = entry.getKey();
			String value = entry.getValue();
		}
		
		//to remove element while iterating, you'll need to use an iterator
		Iterator itr = hm2.entrySet().iterator();
		while(itr.hasNext()){
			Map.Entry pair = (Map.Entry) itr.next();
			itr.remove();
		}
		
		//iterate hashmap for keys and values (google it)

		
		
	}
	
}
