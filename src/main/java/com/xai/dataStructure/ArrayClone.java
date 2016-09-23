package com.xai.dataStructure;

import java.util.ArrayList;
import java.util.List;

public class ArrayClone {

		
	public static void main(String[] args){
		
		List<ArrayItemTest> numList = new ArrayList<ArrayItemTest>();
		
		for(int i=0; i<10; i++){
			numList.add(new ArrayItemTest(i, "Tom " + i));
		}
		
		System.out.println(numList.size());
		
		int size = numList.size();
		for(int i=size; i>0; i--){
			ArrayItemTest item = numList.get(i-1);
			if(item.name.equals("Tom 0") || item.name.equals("Tom 1")){
				numList.remove( item );
			}
		}
		
		System.out.println(numList.size());
	}
}
