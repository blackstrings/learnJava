package com.xai.items;

public class Hammer extends Weapon {
	public Hammer(String name, int minDmg, int maxDmg, int slotCoverage){
		setName(name);
		setMinDmg(minDmg);
		setMaxDmg(maxDmg);
		setSlotCoverage(slotCoverage);
	}
	
	public String toString(){
		return super.toString() + "[minDmg]" + getMinDmg() + "[maxDmg]" + getMaxDmg();
	}
}
