package com.xai.gametest2.bait;

import com.xai.gametest2.interfaces.IsStackable;
import com.xai.gametest2.utils.Utils;
import com.xai.gametest2.utils.Utils.Type;

public class LiveBait extends Bait{
	
	public LiveBait(){}
	
	public LiveBait(Type type){
		quickPick(type);
	}
	
	private void quickPick(Type type){
		if(type.toString().toLowerCase().equals("standard")){
			setName("Small Worms");
			setMaxPrice(2000);
			setRarity(1);
			
			setMaxStack(5);
			setStack(5);
		}
	}
	
}
