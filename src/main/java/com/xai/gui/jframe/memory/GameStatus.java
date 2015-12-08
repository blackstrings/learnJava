package com.xai.gui.jframe.memory;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GameStatus {
	
	//this will hold all the random patterns in advance
	//so we don't have to random numbers per round to lower performance
	private List<Integer> colorIdPool;
	private final int MAX_POOL_SIZE = 20;
	private List<Integer> currentRoundColorIdPattern;
	
	//default time remaining per round
	//each round after will include this baseTime + its round to increase the time
	private int baseTime = 5;
	
	
	//the total number of different colors in the app
	/**
	 * this is the total colors the app will work with, so total colors in this case is 3
	 * To allow the app to support more colors, increase this number
	 * but don't forget you'll also have to create buttons for each new color you add
	 */
	private final int TOTAL_COLORS_SUPPORTED = 3;
	public final int INITIAL_STARTING_NUMBER_TO_MEMORIZE = 3;
	
	//what round we are in
	private int currentRound;
	public int selectedColorId = 0;
	

	public int currentIndexToMatch = 0;
	
	public GameStatus(){
		//pre roll in advance the entire color pattern up to the max pool size allowed
		//we do this only once for performance reason as the Random generator can lower performance if you call it too often
		//so the trick is to just random at the begining of the application, all the numbers we will ever need
		populateColorPool(MAX_POOL_SIZE);
		
		currentRoundColorIdPattern = getCurrentRoundColorIdPattern();	//set the first round color pattern for user to play in round 0
		setCurrentRound(0);	//start at round 0
	}
	
	//the formula for knowing the number of colors to memorize per round is
	//round + INITIAL_STARTING_NUMBER_TO_MEMORIZE
	public int getNumberOfColorsToMemorize(){
		return INITIAL_STARTING_NUMBER_TO_MEMORIZE + currentRound;
	}
	
	
	//populate and pre roll in advance all the patterns we will ever need
	//the app will gradually read the pre-rolled numbers as rounds increase
	//rather than randoming new numbers each round
	private void populateColorPool(int maxPoolSize){

		//prepare arrayList
		colorIdPool = new ArrayList<Integer>();
		
		//loop through and put random numbers into the color pool array up to the max pool size allowed
		Random rand = new Random();
		for(int i=0; i<maxPoolSize; i++){
			
			//random will only generate color id up to the max
			//ex: if max is 3, only numbers 0, 1, 2 can ever be generated per loop
			colorIdPool.add( rand.nextInt(TOTAL_COLORS_SUPPORTED) );
			
		}
		System.out.println(colorIdPool);
		
	}
	
	//when the max is reached, increase the pattern by twice the ammount
	// [1, 1, 0, 2]				//ex: how array can look when max is reached
	// [1, 1, 0, 2, 0, 0, 0, 0] 	//ex: the size is increased
	//when the max is reached again the array will double again for more memory
	// [1, 1, 0, 2, 1, 1, 2, 2, 0, 0, 0, 0, 0, 0, 0, 0]
	/*
	public void increaseColorPoolSize(){
		int[] oldColorPool = colorPool;
		colorPool = new int[colorPool.length*2];	//double the size
		
		//copy over the values
		for(int i=0; i<oldColorPool.length; i++){
			colorPool[i] = oldColorPool[i];
		}
	}
	*/
	
	
	
	//GETTERS and SETTERS

	public int getCurrentRound() {
		return currentRound;
	}

	public void setCurrentRound(int currentRound) {
		this.currentRound = currentRound;
	}
	
	public List<Integer> getColorPool() {
		return colorIdPool;
	}

	public void setColorPool(List<Integer> colorPool) {
		this.colorIdPool = colorPool;
	}
	
	//when you want to get the color array for this round, call this method
	//it returns the complete arrayList that the user should be pressing in order from begining to end
	public List<Integer> getCurrentRoundColorIdPattern(){
		
		//start fresh and give current round color id pool a new array empty list
		currentRoundColorIdPattern = new ArrayList<Integer>();
		
		//only gather the color ids up to the round we are in
		for(int i=0; i<=currentRound; i++){
			//copy values from the original colorId pool into the current round color id pool (the new array we just created)
			currentRoundColorIdPattern.add(colorIdPool.get(i));
		}
		
		//then return this new array which again holds the complete color ids in order for user to press against
		return currentRoundColorIdPattern;
	}
	
	//at the end of each round do this
	public void nextRound(){
		//increment the round
		currentRound++;
		
		//get the next set of color id and pool it
		currentRoundColorIdPattern = getCurrentRoundColorIdPattern();
		
		//reset these variables back to default for the start of the new next round
		selectedColorId = 0;
		currentIndexToMatch = 0;
	}
	
	//helps determine how much time is given per round
	public int getRoundTimer(){
		return baseTime + currentRound;
	}
	
	public boolean isSelectedColorCorrect = false;
	
	//whenever player selects a color button, call this method under that button's event listener
	//and pass that buton's id into the argument, as each button has an id
	public void validateSelectedColorAgainstCurrentPattern(int id){
		setSelectedColorId(id);
		
		if(selectedColorId == currentRoundColorIdPattern.get(currentIndexToMatch)){
			//increment this so next button press will compare to the next index
			currentIndexToMatch++;
			System.out.println("correct");
			
			isSelectedColorCorrect = true;
		}else{
			System.out.println("wrong");
			isSelectedColorCorrect = false;
		}
	}
	
	//check if round should be over
	public boolean validateIsRoundComplete(){
		//validate if we are at the end of the round
		if(currentIndexToMatch >= currentRoundColorIdPattern.size()){
			return true;
		}
		return false;
	}
	
	private boolean isGameOver = false;
	//forces the game to be gameover on call
	public void gameOver(){
		isGameOver = true;
	}
	
	
	private void setSelectedColorId(int selectedColorId) {
		this.selectedColorId = selectedColorId;
	}



	
	//for Timer see
	//http://stackoverflow.com/questions/6811064/jlabel-displaying-countdown-java
}
