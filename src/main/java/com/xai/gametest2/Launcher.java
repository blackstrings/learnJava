package com.xai.gametest2;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.xai.gametest2.FishingRod.CastingPower;
import com.xai.gametest2.factory.FishFactory;
import com.xai.gametest2.factory.FishingRodBuilder;
import com.xai.gametest2.io.Save;
import com.xai.gametest2.utils.Utils;
import com.xai.gametest2.utils.Utils.Type;

public class Launcher {

	private static final Logger logger = Logger.getLogger(Launcher.class);
	
	//test data
	public static List<Fish> fishList;
	private static Fish testFish;
	
	public static void main(String[]args) throws Exception{
		
		fishList = FishFactory.getRandomFishes(20);
		generateRandomEventNumbers();

		// TEST SIMULATOR OF WHAT'S WORKING SO FAR
		// Helps me what next to program and such
		
		// create fishingRod - use direct fishingRod factory for now
		FishingRod fr = FishingRodBuilder.getDefaultRods(Type.AMATEUR);
		
		System.out.println(fr);// print status of fishing rod
		startCastSim(fr);
		
		//where i left off - create fishes, etc
		/*
		 * need a water.class simulator to simulate and spawn fishes
		 * while isCast fishes behaviours will kick whether to bite or not
		 * process bait on rod in water
		 * calculations between bait and available fishes nearby
		 * for now, think of standing on shoreline and how far cast is into the distance
		 * fish behavior on biting bait, calculation of line snag
		 * check how good hook snags fishs (as fish can slip away with bad hook)
		 * 
		 */
		
		// print status of fishingRod
		System.out.println(fr.toString());
		
		//SAVING DATA TO FILE
		//test saving fishes to json then transfer to file
		if(testFish != null){
			Save.saveFish(testFish);
		}
		
	}
	
	private static void startCastSim(FishingRod fr){
		// cast fishing rod
		fr.cast(CastingPower.MED);
		
		// reel in the rod
		int counter = 0;
		while(fr.getIsCast()){
			
			fr.reelIn();
			
			//random event
			randomEvent(fr,counter);
			counter++;
			
			//fr.reelIn();
			
		}
		
		

	}
	
	private static List<Double> randomEventNumbers;
	private static void generateRandomEventNumbers(){
		randomEventNumbers = new ArrayList<Double>();
		//populate list with x random numbers once only, to increase performance
		//then put those random numbers into a map and  use index to access them
		//rather than random a number per loop
		for(int i=0; i<50; i++){
			randomEventNumbers.add(Math.random()*10);
		}
	}
	
	public enum Event {
		E1(2), E2(4);
		private double val;
		private Event(double val){
			this.val = val;
		}
	}
	private static void randomEvent(FishingRod fr, int counter){
		
		if(counter >= randomEventNumbers.size()){	//prevent counter from going over list size
			counter = counter % randomEventNumbers.size();
			
			//repopulate new set of random numbers when all randoms numbers are used
			generateRandomEventNumbers();	
		}
		
		//get random number from eventPool
		double result = randomEventNumbers.get(counter);
		
		//events
		if( result < Event.E1.val){
			eventLineSnap(fr);
			
		}else if( result < Event.E2.val){

			eventFishOn(fr);
		}
		//do nothing
	}
	
	private static void eventLineSnap(FishingRod fr){
		fr.snapLine();
		
		
	}
	private static void eventFishOn(FishingRod fr){
		fr.fishIsOn();	//to break out of the reeling, not best design but will do for now
		fr.fishIsOff();
		Fish fish = FishFactory.getOneRandomFish();
		//Fish fish = fishList.get( ((Double)(Math.random()*fishList.size())).intValue() );
		testFish = fish;
		logger.info("caught a fish " + fish.toString());
	}
	
}
