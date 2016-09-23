package com.xai.dataStructure;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ArrayBasicDemo {
	
	// Variables
	// ArrayList 1 - Initialize ArrayList
	//
	private List<String> names = new ArrayList<String>(){{
		add("No");
		add("Yes");
	}};
		
	
	/*
	 * constructor
	 */
	public ArrayBasicDemo(){}
	
	
	/*
	 * MAIN
	 */
	public static void main(String [] args){

		//================================================================================
		// 1.0 - create basic array and ways to initialize arrays
		//================================================================================
		
		// Basic Array, size have to be defined on creation
		int[] arr = new int[30];
		
		int[] arr1 = new int[] {0,1,2,3,4,5,6};	// array size will automatically be 6
			// arr1[7] = 7;						// will result in ArrayIndexOutOfBoundsException
		arr[0] = 5;
		// have to initialize size if doing it this way
		boolean[] boolArray = new boolean[10];	
		boolArray[0] = true;
		boolArray[1] = false;
		boolArray[2] = true;
		
		// iterate through array and print boolean values
		for(boolean bool: boolArray){
			if(bool){
				System.out.print("T ,");
			}else{
				System.out.print("F ,");
			}
		}
		
		newLine("1.0 - Bool Array - Enhanced for loop ", 2);
		
		/*
		 * 1.1 - Size is Dynamic
		 * ArrayList can only hold objects or references, so to hold primitive types like true, 1, you have to use their wrapper class
		 * By using <E> generic you are restricting the arrayList to hold only the specified type
		 */
		ArrayList<Integer> intArr = new ArrayList<Integer>();
		intArr.add( new Integer(19) );		// one way to add interger
		intArr.add( 21 ); 					// auto converts to Integer
		
		System.out.print(intArr);
		
		newLine("1.1 : Array List", 2);
		
		/*
		 * 1.2 - different ways to initialize ArrayList
		 * 
		 */
		List<String> strList = new ArrayList<String>();
		strList.add("one");
		strList.add( new String("two") );
		
		System.out.print(strList);
		
		newLine("1.2 - simple way to print Array List by printing array name", 2);

		
		//================================================================================
		// 2.0 - Array setup
		//================================================================================
		for (int i = 0; i < arr.length; i++) {		// for loop
			arr[i] = i;
		}
		
		
		//================================================================================
		// 3.0 - enhanced for-loop for basic array
		/*
		 * cannot remove an index or list item while iterating through it with this loop
		 */
		//================================================================================
		for (int num : arr) {						
			System.out.print(num + ",");
		}
		
		newLine("3.0 - Enhance for loop for basic array", 2);
		
		//================================================================================
		// 4.0 - allow you to remove an index while looping through
		//================================================================================
		List<String> myList = new ArrayList<String>();
		
		// populate array with strings
		for(int i=0; i<10; i++){
			myList.add("item"+i);
		}
		
		// iterate through array list (Long version)
		for(Iterator<String> str = myList.iterator(); str.hasNext(); ){
			String item = str.next();
			System.out.print(item+", ");
		}
		
		newLine("4.0 - Iterator method for ArrayList (Long ver)", 2);
		
		//4.0a
		// iterate using shorter version
		for(int i = 0; i < myList.size(); i++){
			System.out.print( myList.get(i) + ", " );
		}
		
		newLine("4.0a - For loop for ArrayList (shorter ver)", 2);
		
		// 4.1
		// iteratre through array list (short version)
		for(String str : myList){
			System.out.print(str);
		}
		
		newLine("4.1 - Enhanced for loop for ArrayList (short ver)", 2);
		
		
		//4.2 - proves that enhanced for loop passes by reference and not by copy
		List<Person> persons = new ArrayList<Person>();
		for(int i=0; i<3; i++){
			Person temp = new Person(i);
			temp.setName("tom"+i);
			persons.add(temp);	
		}
		
		List<Person> persons2 = new ArrayList<Person>();
		for(Person p : persons){
			persons2.add(p);
		}
		persons2.get(0).setName("Mary");
		
		for(Person p : persons){
			System.out.print(p.getName() + ", ");
		}
		
		System.out.println();
		
		for(Person p : persons2){
			System.out.print(p.getName() + ", ");
		}
		newLine("4.2 - Enhanced for loop for ArrayList (short ver)", 2);
		
		
		
	}
	
	
	// new blank line breaks
	private static void newLine(String str, int n){
		System.out.println();
		System.out.println("Printout " + str + " Done ...");
		for(int i=0; i<n; i++){
			System.out.println();
		}
	}


	
}
