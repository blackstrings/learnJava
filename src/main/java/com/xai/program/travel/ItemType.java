package com.xai.program.travel;

public enum ItemType {
	AMMO(50), FOOD(75), WOOD(50), RIFLE(100);
	
	private int c;
	private ItemType(int c){
		this.c = c;
	}
	public int getCost(){
		return c;
	}
	public String toString(){
		return super.toString() + ":" + c;
	}
}
