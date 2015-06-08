package com.xai.loops;

import java.util.Enumeration;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

public class Iterators {

	public static void main(String [] args){
		
		System.out.println("Early Iterator In Java -----------");
		Vector names = new Vector();
		names.addElement("tom");
		names.addElement("mary");
		
		//using enumeration
		Enumeration e = names.elements();
		while (e.hasMoreElements())
		  {
		    String name = (String) e.nextElement();
		    System.out.println(name);
		  }
		
		
		
		System.out.println("Mid Java Iterator versions 1.2 through 1.4, ---------");
		List names2 = new LinkedList();

		// ... add some names to the collection
		names2.add("kim");
		names2.add("bill");
		
		//using iterator
		Iterator i = names2.iterator();
		while (i.hasNext())
		  {
		    String name = (String) i.next();
		    System.out.println(name);
		  }
		
		
		
		System.out.println("After Java 5 Iterations --------------");
		List<String> names3 = new LinkedList<String>();
		names3.add("John");
		names3.add("kou");

		//using enchane for loop
		for (String name : names3)
		    System.out.println(name);
		
	}
	
}
