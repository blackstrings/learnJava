package com.xai.gui.jframe.memory;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

//holds the important data such as the status of the game properties throughout the rounds
public class GameData {
	
	//this will hold all the random patterns in advance
	//so we don't have to random numbers each round
	private List<Integer> colorIdPool;
	
	//the max number a player can memorize up to and win the game
	//changes are the higher this number, the rarer it is to actually have a player win
	private final int maxPoolSize = 50;
	
	//each round this array is the one we will compare against
	//the color buttons that are pressed will need to follow the order of IDs this array
	private List<Integer> currentRoundColorIdPattern;
	
	//the total number of different colors in the game
	//this is the total colors available in the game
	//To allow the game to support more colors, increase this number
	//but don't forget you'll also have to create buttons for each new color you add
	private final int gameTotalColors = 3;
	public final int initialStartingNumberToMemorize = 2;
	
	//default time remaining per round
	//every round will include the baseCountDownTimer + currentRound to increase the time
	//the number is best when it is the same as the initialStartingNumberToMemorize
	//otherwise feel free to tweak this number to any other number
	private int baseCountDownTimer = initialStartingNumberToMemorize;
	
	//track what round we are in
	private int currentRound;
	
	//each time a color button is press, use this to record it
	public int selectedColorId = 0;
	
	//keeps track of what current index we are in within the color pattern array
	//so we can compare the next selected color button to the correct next id in the array
	public int currentRoundColorIdPatternIndexToMatch = 0;
	
	public boolean isSelectedColorCorrect = false;
	
	public GameData(){
		//generate a pool of random colorIds
		//the idea of pooling is gathering in advance a bunch of data into a pool/array
		//and then just reuse them later
		//rather than generate data at runtime for every action, 
		//supposedly this increase performance according to forum talk
		populateColorIdPool(maxPoolSize);
		
		//set the first round color pattern for user to play in round 0
		currentRoundColorIdPattern = getCurrentRoundColorIdPattern();	
		setCurrentRound(0);	//start at round 0
	}
	
	//the formula for knowing the number of colors to memorize per round is
	//currentRound + initialStartingNumberToMemorize
	public int getNumberOfColorsToMemorize(){
		return initialStartingNumberToMemorize + currentRound;
	}
	
	//for performance, i read it is better to
	//pre-random in advance the entire color pattern up to the max pool size allowed
	//so the trick is to just random at the beginning of the application, 
	//we random all the numbers we will ever need for the game, to simply put
	//the game will gradually read the pre-rolled numbers as rounds increase
	//rather than randoming new numbers each round
	private void populateColorIdPool(int maxPoolSize){

		//prepare an empty arrayList
		colorIdPool = new ArrayList<Integer>();
		
		//loop through and put random numbers into the color pool array 
		//up to the max pool size allowed
		Random rand = new Random();
		for(int i=0; i<maxPoolSize; i++){
			
			//random will only generate color id up to the max
			//ex: if max is 3, only numbers 0, 1, 2 can ever be generated per loop
			colorIdPool.add( rand.nextInt(gameTotalColors) );
		}
		
		//test to see the colors we generated at start
		//TODO turn off when we finalize game
		System.out.println(colorIdPool);
		
	}
	
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
	
	//this part took me forever to get my head around
	//use this when we want to get the color array 
	//to compare against for the current round
	//it returns the complete arrayList that the user should 
	//be pressing in order from beginning to end
	public List<Integer> getCurrentRoundColorIdPattern(){
		
		//prepare a new empty array list
		currentRoundColorIdPattern = new ArrayList<Integer>();
		
		//only gather the color ids up to the round we are in
		//we don't care about the other ids beyond the current round
		for(int i=0; i<=getNumberOfColorsToMemorize(); i++){
			//copy values over to the new arrayList from the colorIdPool
			currentRoundColorIdPattern.add(colorIdPool.get(i));
		}
		
		//then return this new array which again holds the complete 
		//color ids in order for user to press against
		return currentRoundColorIdPattern;
	}
	
	//at the end of each game round call this
	public void nextRound(){
		//increment the round to the next round
		currentRound++;
		
		//create the next colorId set from the color id pool
		currentRoundColorIdPattern = getCurrentRoundColorIdPattern();
		
		//reset these variables back to default for the next new round
		selectedColorId = 0;
		currentRoundColorIdPatternIndexToMatch = 0;
	}
	
	//helps determine how much time should be given to player per round
	public int getCurrentRoundTime(){
		//this will fix the count down timer being zero at round zero
		if(currentRound == 0){
			//in this case, make sure baseCountDownTimer is never zero to begin with
			//otherwise you'd still get zero at round 0
			return baseCountDownTimer;
		}
		//all rounds after zero, we will return this formula instead
		//this means player don't get 1 additional sec per round
		//instead player gets 1 additional second only for every 2 rounds completed
		return baseCountDownTimer + currentRound/2;
	}
	
	
	
	//whenever player selects a color button, call this method under that button's event listener
	//and pass that buton's id into the argument, as each button has an id
	public void validateSelectedColorAgainstCurrentPattern(int id){
		setSelectedColorId(id);
		
		//compare he selected colorId against the colorId in the array
		//we need to compare against
		if(selectedColorId == currentRoundColorIdPattern.get(currentRoundColorIdPatternIndexToMatch)){
			
			//increment this so next button press will compare to the next index in array
			currentRoundColorIdPatternIndexToMatch++;
			//System.out.println("correct");
			
			//flag that the selectedColor was the correct color pressed
			isSelectedColorCorrect = true;
		}else{
			//System.out.println("wrong");
			//flag that the selectedColor was the wrong color pressed
			isSelectedColorCorrect = false;
		}
	}
	
	//check if round should be over
	public boolean validateIsRoundComplete(){
		//validate if we are at the end of the round
		//if the currentIndexToMatch becomes greather than the array size
		//we know we are done with the round
		if(currentRoundColorIdPatternIndexToMatch >= currentRoundColorIdPattern.size()){
			return true;
		}else{
			return false;
		}
	}
	
	//this is public so we can access it whenever from the gui
	public boolean isGameOver = false;
	
	//forces the game to be game over
	public void gameOver(){
		//keep track of our game status
		isGameOver = true;	
	}
	
	private void setSelectedColorId(int selectedColorId) {
		this.selectedColorId = selectedColorId;
	}
}
