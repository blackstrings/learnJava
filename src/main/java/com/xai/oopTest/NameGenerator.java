package com.xai.oopTest;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;

/*
 * Upon creation of this instance, the constructor will generate
 * random names up to the specify NAMEQTY
 * This class will then use hashmap names to store the randomized alphabet names
 * 
 * any class can use names to access the database
 * 
 * @param 
 */
public class NameGenerator implements IGameObject {

	// hashmap where all the generated names are stored
	public HashMap<Integer, String> names;

	private String strGenerator = "";

	private int NAMEQTY = 10; // # of names to generate

	private int CHARMIN = 97; // ASCII codes from a-z
	private int CHARMAX = 123; // the last letter z

	private int LETTERMIN = 4; // min length of character name
	private int LETTERMAX = 7; // max length of character name

	public NameGenerator() {

		generateNames();

	}
	
	/**
	 * cache the generated names to a file
	 */
	public void cacheName(String fileIn){
		if(fileIn == null){
			Path path = Paths.get("res/files/nameCache.txt");
		}else{
			Path path = Paths.get(fileIn);
		}
	}
	
	/**
	 * Generate random names into hashmap names upon call
	 */
	private void generateNames(){
		
		names = new HashMap<Integer, String>(); // create hashmap

		for (int i = 0; i < NAMEQTY; i++) {

			int randCharInt;

			int randMaxLetter;
			randMaxLetter = LETTERMIN
					+ (int) (Math.random() * (LETTERMAX - LETTERMIN));

			for (int n = 0; n < randMaxLetter; n++) {

				randCharInt = CHARMIN
						+ (int) (Math.random() * (CHARMAX - CHARMIN));
				String str = ""; // convert ascii to char letter
				strGenerator += (char) randCharInt;
			}

			names.put(i, strGenerator);
			strGenerator = ""; // reset str
		}
		
	}

	/*
	 * public static void main(String [] args){ NameGenerator ng = new
	 * NameGenerator();
	 * 
	 * for (int key : ng.names.keySet()) {
	 * System.out.println("------------------------------------------------");
	 * System.out.println("Iterating or looping map using java5 foreach loop");
	 * System.out.println("key: " + key + " value: " + ng.names.get(key)); }
	 * 
	 * 
	 * 
	 * }
	 */

}
