package com.xai.constructors;

import com.xai.objects.Cat;

//the purpose of copy constructors is for security purposes
//It creates a brand new object off of the old object with a different address in memory
//so chnaging the new object does not affect or change the old object in any way
//deep copy means we copy over the references of other objects as well
public class ConstructorDeepCopyDemo {

	public static void main(String[]args){
		
		Cat d1 = new Cat("Tom", 1L);
		d1.setEyeSize(44.0);
		
		//copy d1 to d2
		Cat d2 = new Cat(d1);
		d2.setName("kim");
		d2.setEyeSize(55.0);
		
		//the name of the 2nd dog does not change the first dog attributes
		System.out.println(d1);
		System.out.println(d2);
		
	}
	
}
