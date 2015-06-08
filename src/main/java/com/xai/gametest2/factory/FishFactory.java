package com.xai.gametest2.factory;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

import com.lao.player.Player;
import com.lao.player.factory.PlayerNames;
import com.xai.gametest2.Fish;
import com.xai.gametest2.GameObject;
import com.xai.gametest2.Reel;
import com.xai.gametest2.FishingRod;
import com.xai.gametest2.loader.XmlLoader;
import com.xai.gametest2.utils.Utils;
import com.xai.gametest2.utils.Utils.Type;

/**
 * Loads blueprintData fishData and creates instances from the bluePrints
 * @author xlao
 *
 */
public class FishFactory extends Factory {

	private static Random random = new Random();
	
	public FishFactory(){}
	
	/**
	 * load data of all possible fishes
	 * @return
	 */
	private static List<Fish> loadAllFishDataBluePrint(){
		List<Fish> fishDataBluePrintList = new ArrayList<Fish>();
		
		//if you wish to update the enum values, do it now
		//this allows you to create a read file and load to control values from a text file
		//here is just a test example that you can modify a enum value and that it works
		FishData.RAINBOW_TROUT.setMaxSize(500.0);
		
		//map all possible fish types first into a list
		for(FishData data:FishData.values()){
			Fish fishDataBluePrint = new Fish(data.getName(), data.getMinSize(), data.getMaxSize(), data.getLbsPerFoot());
			fishDataBluePrintList.add(fishDataBluePrint);
		}
		return fishDataBluePrintList;
	}
	
	/**
	 * Get a list of random fishes
	 * @param type
	 * @return
	 * @throws Exception
	 */
	public static List<Fish> getRandomFishes(int qty){
		List<Fish> generatedFishList = new ArrayList<Fish>();
		List<Fish> allFishDataBluePrint = loadAllFishDataBluePrint();
		int totalBluePrintSize = allFishDataBluePrint.size();
		
		//populate random fishes from the bluePrints
		for(int i=0; i<qty; i++){
			
			//get random index within the listSize, 
			//it is possible to get same bluePrint per random
			int randomIndex = ((Double)(Math.random() * totalBluePrintSize)).intValue();
			Fish tempFish = new Fish( allFishDataBluePrint.get(randomIndex) );
			
			//modify fish stats
			randomStats(tempFish);
			generatedFishList.add(tempFish);
		}
		allFishDataBluePrint = null; // don't need it anymore
		return generatedFishList;
	}
	
	
	
	public static Fish getOneRandomFish(){
		return getRandomFishes(1).get(0);
	}
	
	private static void randomStats(Fish fish){
		double minSize = fish.getProp(Prop.MIN_SIZE);
		double maxSize = fish.getProp(Prop.MAX_SIZE);
		double lbsPerFoot = fish.getProp(Prop.LBS_PER_FOOT);
		
		//to keep the random number under 2 decimal
		DecimalFormat df = new DecimalFormat("####0.00");
		double size = Utils.randomBetweenTwoDouble(minSize, maxSize);
		
		fish.setProp(Prop.SIZE, size );
		fish.setProp(Prop.WEIGHT, Utils.formatDouble(size * lbsPerFoot));	//2lbs per feet
		
	}
	
	/*
	private static Integer getRandomInteger(){
		return random.nextInt(100);
	}
	private static Double getRandomDouble(){
		return random.nextDouble();
	}
	*/
	
	
}
