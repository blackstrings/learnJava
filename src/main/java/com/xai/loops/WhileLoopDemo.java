package com.xai.loops;

public class WhileLoopDemo {

	public static void main(String [] args){
		
		int counter = 0;
		while(counter < 5){
			
			System.out.println("while ... " + counter);
			//usually towards the end of the while
			//you need to make sure the statement "counter < 5"
			//will eventually be false or the opposite to cancel the loop
			//otherwise you'll have an infinite loop and crash/freeze your program
			//when you run it
			
			//in this case counter++ will eventuall make "counter < 5" false
			//and cancel the loop
			counter++;
		}
		
		//when the while loop exits, this code will be hit
		System.out.println("while loop ended");
		
	}
}
