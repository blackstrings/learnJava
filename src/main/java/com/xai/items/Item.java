package com.xai.items;

public abstract class Item implements IIsUsable, IIsStoreable{	
	private int slotCoverage;
	private boolean isUsable = true;
	private String name;
	
	public boolean getIsUsable(){
		return isUsable;
	}
	
	public void setIsUsable(boolean isUsable){
		this.isUsable = isUsable;
	}
	
	public boolean use(){
		return false;
	}
	
	public void setSlotCoverage(int slotCoverage){
		this.slotCoverage = slotCoverage;
	}
	public int getSlotCoverage(){
		return this.slotCoverage;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String toString(){
		return this.name + "[slotCoverage]" + getSlotCoverage() + "[usable]" + isUsable;
	}
	
}
