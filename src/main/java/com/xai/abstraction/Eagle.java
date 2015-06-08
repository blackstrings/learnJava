package com.xai.abstraction;

import java.util.List;

public class Eagle extends Bird {
	
	public Eagle(String name, int hp, List<Food.TYPE> consumableFoodTypes){
		super(name, hp, consumableFoodTypes);
	}
	
	protected void dive(){
		System.out.println( getName() + " is diving...");
	}
	
	@Override
	public String toString(){
		return super.toString() + "[Eagle]";
	}
}
