package com.xai.dataStructure;

import java.util.Iterator;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.TreeMap;

import org.springframework.util.StopWatch;

public class TreeDemo {

	public static void main(String [] args){
		
		TreeMap tm = new TreeMap();
		
		/*
		tm.put("Tim", new Double(5));
		tm.put("Kim", new Double(3));
		tm.put("Bob", new Double(6));
		tm.put("Sam", new Double(9));
		*/
		
		StopWatch sw = new StopWatch();
		sw.start();
		
		//populate the tree
		for(int i=0; i<100; i++){
			Random random = new Random();
			double rand = random.nextDouble() * 100;
			tm.put("tim" +i, new Double(rand));
		}
		
		sw.stop();
		
		System.out.println("Took " + sw.getTotalTimeSeconds() + " seconds to generate the map");
		sw = new StopWatch();	//reset watch
		/*
		sw.start();
		Set set = tm.entrySet();
		Iterator i = set.iterator();
		while(i.hasNext()){
			Map.Entry me = (Map.Entry)i.next();
			System.out.print(me.getKey() + ": " );
			System.out.println(me.getValue());
		}
		sw.stop();
		System.out.println("Took " + sw.getTotalTimeSeconds() + " seconds to write map here");
		*/
		
		System.out.println();
		
		sw.start();
		//access and update same item in tree is O(1)
		double balance = ((Double)tm.get("tim90")).doubleValue();
		tm.put("Tim90", new Double(balance + 1000));
		sw.stop();
		
		System.out.println("Took " + sw.getTotalTimeSeconds() + " seconds to get and put tim90");
		System.out.println("Tim's new balance " + tm.get("Tim90"));
		
		
	}
	
}
