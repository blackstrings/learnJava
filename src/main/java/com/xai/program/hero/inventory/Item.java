package com.xai.program.hero.inventory;

public abstract class Item {

	protected int maxStack = 0;	//maxStack this item can be stacked
	protected int currStack = 0;	//tracks the current stack per use
	
	protected String name;
	
	public Item(String name, int maxStack){
		this.name = name;
		this.maxStack = maxStack;
		this.currStack = maxStack;
	}
	
	public void setName(String name){
		this.name = name;
	}
	
	public void setMaxStack(int maxStack){
		this.maxStack = maxStack;
	}
	
	/**
	 * refills stack back to max
	 */
	public void resetStack(){
		currStack = maxStack;
	}
	
	public abstract boolean useOn(Object targetUseOn);
	
}
