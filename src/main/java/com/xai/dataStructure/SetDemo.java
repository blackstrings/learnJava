package com.xai.dataStructure;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 * Like an arrayList sets can only have one copy of each unique array.
 * By adding more of the same say string object, it will only carry the one same string
 * and not create duplicates. whereas in arrayList, you can have duplicates.
 * @author xlao
 *
 */
public class SetDemo {

	public static void main(String [] args){
		
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("sam", "kully");
		
		Set<Integer> sets = new HashSet<Integer>();
		sets.add(5);
		sets.add(7);
		sets.add(2);
		sets.add(9);
		sets.add(5);
		
		System.out.println(sets);
		
		//use treeset to sort
		
		TreeSet<Integer> tree = new TreeSet<Integer>(sets);	
		System.out.println(tree);
		
	}
}
