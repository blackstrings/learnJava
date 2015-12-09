package com.xai.loops;

public class ForLoopDemo {

	public static void main(String [] args){
		
		//longer way to write a for loop
		int i;	//create i variable inside main scope
		int max = 3;
		for(i=0; i<max; i++){
			System.out.println("longer way..." + i);
		}
		
		//shorter way to type
		//notice i can't reuse the variable i
		//because i is already used within this scope (somewhat global)
		for(int k=0; k<max; k++){
			System.out.println("shorter way.." + k);
		}
		
		//notice i can reuse the variable k without error
		//because k in the previous loop, was created inside the for loop
		//it wasn't created inside the main scope
		//there are times when you want to use this method
		//and times when you want to use the first method, the longer method
		//to create your variable
		for(int k=0; k<max; k++){
			System.out.println("reusing k..." + k);
		}
		
	}
}
