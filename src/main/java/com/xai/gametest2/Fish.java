package com.xai.gametest2;

import com.xai.gametest2.character.Character;

public class Fish extends Character {
	
	public Fish(String name, double minSize, double maxSize, double lbsPerFoot){
		setProp(Prop.NAME, name);
		setProp(Prop.MIN_SIZE, minSize);
		setProp(Prop.MAX_SIZE, maxSize);
		setProp(Prop.LBS_PER_FOOT, lbsPerFoot);
		setProp(Prop.SIZE, 0);		//determined at factory creation time base on random
		setProp(Prop.WEIGHT, 0);	//determined at factory creation time as random base on random size
	}
	
	public Fish(Fish fish){
		this.setPropertyMap( fish.getPropertyMap());
	}
	
	public void bite(){
		
	}
	
	public String toString(){
		return "[" + getProp(Prop.NAME) + " "
				+ getProp(Prop.SIZE) + "' "
				+ getProp(Prop.WEIGHT) + " LBS"
				+ "]";
	}
}
