package com.xai.gametest2.bait;

import com.xai.gametest2.utils.Utils;
import com.xai.gametest2.utils.Utils.Type;

public class Lure extends Bait {

	public Lure(){}
	
	/**
	 * Mod Construct - quick pick
	 * @param type
	 */
	public Lure(Type type){
		quickPick(type);
	}
	
	private void quickPick(Utils.Type type){
		if(type.toString().toLowerCase().equals("standard")){
			setName("Plastic Worm");
			setMaxPrice(1000);
			setRarity(1);
			
			setMaxDurability(10);
			setDurability(10);
		}
	}
}
