package com.xai.abstraction;

import java.util.List;

public class Bird extends Animal{

	private int wings = 2;
	
	public Bird(String name, int hp, List<Food.TYPE> consuambleFoodTypes){
		super(name, hp, consuambleFoodTypes);
	}
	
	public String toString(){
		return super.toString() + "[Bird:" + "(" + wings + " wings)]";
	}

	public int getWings() {
		return wings;
	}

	public void setWings(int wings) {
		this.wings = wings;
	}
	
}
