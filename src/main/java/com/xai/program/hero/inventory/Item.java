package com.xai.program.hero.inventory;

public abstract class Item {

	protected String name;
	
	public Item(String name){
		this.name = name;
	}
	
	public abstract boolean useOn(Object targetUseOn);
	
}
