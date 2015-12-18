package com.xai.program.travel;

public class Traveler {

	private Stats stats;
	public Traveler(String name, Stats stats){
		this.name = name;
		this.stats = stats;
	}
	
	public Traveler(){}
	
	
	private String name;
	
	public Stats getStats(){
		return stats;
	}
	public void setStats(Stats stats){
		this.stats = stats;
	}
	
	public void setName(String name){
		this.name = name;
	}
	
	public String getName(){
		return name;
	}
}
