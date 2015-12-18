package com.xai.program.travel;

import java.util.ArrayList;
import java.util.List;

public class User {

	private List<Traveler> travelers;
	private List<Item> items;
	public int g = 0;
	private List<Environment> envs;
	
	
	public User(int g){
		this.g = g;
		this.travelers = new ArrayList<Traveler>();
		this.items = new ArrayList<Item>();
	}
	
	public boolean isTravelerEmpty(){
		if(travelers.isEmpty()){
			return true;
		}
		return false;
	}

	//GETTERS SETTERS
	public List<Traveler> getTravelers() {
		return travelers;
	}

	public void setTravelers(List<Traveler> travelers) {
		this.travelers = travelers;
	}
	
	public void add(Traveler t){
		travelers.add(t);
	}
	
	public void add(List<Traveler> travelers){
		this.travelers = travelers;
	}
	
	public String getTravelerNameAt(int index){
		return travelers.get(index).getName();
	}
	
	public Traveler getTravelerAt(int index){
		return travelers.get(index);
	}
	
	public void removeTravelerAt(int index){
		travelers.remove(index);
	}
	
	public int getTravelerSize(){
		return travelers.size();
	}
	
	public void add(Item item){
		items.add(item);
	}
	
	public void setEnv(List<Environment> envs){
		this.envs = envs;
	}
	
	public List<Environment> getEnvs(){
		return new ArrayList<Environment>(envs);
	}
	
}
