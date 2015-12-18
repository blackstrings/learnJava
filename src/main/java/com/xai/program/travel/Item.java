package com.xai.program.travel;

public class Item {

	private ItemType desc;
	
	public Item(ItemType desc){
		this.desc = desc;
	}
	
	public String toString(){
		 return desc.name() + ":" + desc.getCost();
	}
	
	public int getCost(){
		return desc.getCost();
	}
}
