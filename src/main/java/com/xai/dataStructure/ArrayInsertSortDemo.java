package com.xai.dataStructure;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.xai.utils.Utils;

/**
 * This is the long way of implmenting insert sort. The short way is to use an existing sort
 * in collections
 * @author xlao
 *
 */
public class ArrayInsertSortDemo {

	public static void main(String[] args){
		
		List<Integer> list = new ArrayList<Integer>();
		
		for(int i=0; i<10; i++){
			list.add((int)Utils.randomBetweenTwoDouble(0, 100));
		}
		
		for(int i:list){
			System.out.print(i+",");
		}
		
		System.out.println();

		list = arrayListInsertSort(list);
		
		for(int i:list){
			System.out.print(i+",");
		}
	}
	
	//insert sort on array list - but you can use collections to sort the list for you
	//insert sort works in a linear fashion, and iterates for every index until found
	//if not found the insert gets insert at the end
	public static List<Integer> arrayListInsertSort(List<Integer> list){
		//holds the sorted numbers
		List<Integer> sortedList = new ArrayList<Integer>();
		
		int s = 0;
		int incomingVal = 0;
		
		for(int i=0; i<list.size(); i++){
			incomingVal = list.get(i);
			
			if(sortedList.size() > 0){	
				
				boolean smallerFound = false;
				for(int j=0; j<sortedList.size(); j++){
					
					int nestVal = sortedList.get(j);
					
					//if smaller than any  preceeding, insert at that position
					if( incomingVal < nestVal){  
						sortedList.add(j, incomingVal);
						smallerFound = true;
						break;
					}
				}
				
				//if not smaller than any preceedings, insert at end
				if(!smallerFound)sortedList.add(incomingVal);
				
			}else{
				//always add first one without doing any comparing
				sortedList.add(0, incomingVal);
			}
		}
		
		return sortedList;
	}
	
	public static void InsertionSort( int [ ] num)
	{
	     int j;                     // the number of items sorted so far
	     int key;                // the item to be inserted
	     int i;  

	     for (j = 1; j < num.length; j++)    // Start with 1 (not 0)
	    {
	           key = num[ j ];
	           for(i = j - 1; (i >= 0) && (num[ i ] < key); i--)   // Smaller values are moving up
	          {
	                 num[ i+1 ] = num[ i ];
	          }
	         num[ i+1 ] = key;    // Put the key in its proper location
	     }
	}
}
