package com.xai.dataStructure;

import java.util.HashMap;

/**
 * <p>
 * The purpose of a hashmap is to be able to store an object as a key/value pair
 * and be able to retrieve the object upon calling the key.
 * </p>
 * <p>
 * It is important to store key objects whose class is immutable, or that cannot change,
 * hence is why the primitive objects String, Integer and other wrapper classes
 * are good key object candidates.
 * </p>
 * <p>
 * If you want to make your own mutable object as key, then you have to make sure the
 * state change for the key object does not change the hash code of the object.
 * This is done by overriding the hashCode() method and also the equals 
 * as part of the hashing contract.
 * </p>
 * <p>
 * We do this, Because the JVM will generate a new hashcode for the 
 * object everytime the object has a change
 * </p>
 * <p>
 * Though there are chances of collision where two or more objects may share the same
 * bucket in the hashcode, it'll move to the next in a linear fashion until the match is found
 * </p>
 * <p>
 * The more collision you have, the longer the hashing find
 * </p>
 *
 */
public class HashingDemo {

	public static void main(String [] args){
	HashMap<Person, String> map = new HashMap<Person, String>();
	
	Person p1 = new Person(1);
	p1.setName("Person_One");
	
	Person p2 = new Person(2);
	p2.setName("Person_Two");
	
	//put mutable key and value in a map
	map.put(p1, p1.getName());
	map.put(p2, p2.getName());
	
	//change the keys state so hashmap should be calculated again
	p1.setName("personone");
	p2.setName("persontwo");
	
	//success we shouldn't be able to change the values
	System.out.println(map.get(p1));	//Person_One
	System.out.println(map.get(p2));	//Person_Two
	
	//try new person with same id,( this part i'm still not sure or get it)
	Person p3 = new Person(1);
	p3.setName("Person_Three");
	
	//success we are still able to get back the value for person 1
	System.out.println(map.get(p3));	//Person_One
	
	
	}
	
	
}
