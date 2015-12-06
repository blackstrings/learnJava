package com.xai.gui.jframe.sonygame;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Flash {
	
	// keep track of current rounds of the game
	private int round = 0;
	// The amount of time player has per rounds
	private int timeDelayEachRounds = 0;
	// Holds all the orders of colors
	private List<Integer> colorIdPool;
	private final int MAX_POOL_SIZE = 10; // TODO COME BACK TO CHANGE 100
	
	

	public Flash(){	
		// calling method to generate a pool of color
		generatePool();
		showRoundColor();
		
	}
	
	private void generatePool(){

		// Using Random class to generate a random
		Random random = new Random();
		colorIdPool = new ArrayList<Integer>();

		for (int i = 0; i < MAX_POOL_SIZE; i++) {

			// Random an integer between that is either 0, 1, or 2
			colorIdPool.add(random.nextInt(3));

		}

		System.out.println(colorIdPool);// Using to Test random
	}
	
	private void nextRound(){
		round ++; 
		
	}
	
	private void showRoundColor(){
		
		nextRound();
		nextRound();
		nextRound();
		List<Integer> temp = new ArrayList<Integer>(10);
		// Get the rounds colorId into a local array and print that local array
		for(int i = 0; i < round; i ++){
			temp.add(colorIdPool.get(i));
		}
		System.out.print(temp);
		
		
	}

}
