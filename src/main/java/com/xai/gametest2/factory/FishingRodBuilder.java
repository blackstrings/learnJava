package com.xai.gametest2.factory;

import java.util.Map;

import com.xai.gametest2.GameObject;
import com.xai.gametest2.Reel;
import com.xai.gametest2.FishingRod;
import com.xai.gametest2.loader.XmlLoader;
import com.xai.gametest2.utils.Utils;
import com.xai.gametest2.utils.Utils.Type;

public class FishingRodBuilder extends Factory {

	public FishingRodBuilder(){}
	
	/**
	 * quick pick fishing rod
	 * @param type
	 * @return
	 * @throws Exception
	 */
	public static FishingRod getDefaultRods(Type type) throws Exception{
		FishingRod fishingRod = new FishingRod(type);
		fishingRod.setReel( new Reel(type) );
		return fishingRod;
	}
	
	/**
	 * This is the superior way to create a fishing rod
	 * which searches the database to create the fishing rod
	 * @param id
	 * @return
	 */
	public static FishingRod getById(int id){
		FishingRod fr = new FishingRod();
		
		// load data
		String file = Utils.Xml.ITEM.toString().toLowerCase() + ".xml";
		Map<String, Object> data = XmlLoader.getById(id, file);
		
		//TODO push into hashmap
		
		
		//TODO get reel id from loaded rod
		//ReelFactory.create(reelID);
		//fr.setReel( new Reel(type) );
		
		
		return fr;
	}
	
	
}
