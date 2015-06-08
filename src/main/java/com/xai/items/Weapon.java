package com.xai.items;

public abstract class Weapon extends Item implements IWeapon {
	
	private int minDmg;
	private int maxDmg;
	
	public Weapon(){
		
	}
	
	public boolean use(){
		if(getIsUsable()){
			return true;
		}
		return false;
	}

	@Override
	public void setMinDmg(int minDmg) {
		this.minDmg = minDmg;
		
	}

	@Override
	public int getMinDmg() {
		return minDmg;
	}

	@Override
	public void setMaxDmg(int maxDmg) {
		this.maxDmg = maxDmg;
	}

	@Override
	public int getMaxDmg() {
		return this.maxDmg;
	}
	
}
