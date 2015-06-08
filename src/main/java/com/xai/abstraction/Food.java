package com.xai.abstraction;

import java.util.List;

public class Food extends Item implements IConsumable{

	private String name;
	public enum TYPE {MEAT,FRUIT, VEGGIE, LIQUID}
	private TYPE type;
	
	public enum STATUS {RAW,COOKED,ROTTEN}
	private STATUS status;
	
	private List<Effector> foodEffectors;
	
	public Food(String name, List<Effector> foodEffectors, STATUS status, TYPE type){
		setName(name);
		setFoodEffectors(foodEffectors);
		setStatus(status);
		setType(type);
	}
	
	@Override
	public List<Effector> applyEffects(){
		return foodEffectors;
	}
	
	public boolean canConsume(List<String> consumableFoodTypes){
		for(String consumableFoodType : consumableFoodTypes){
			if(consumableFoodType.equals(getType())){
				return true;
			}
		}
		
		return false;
	}
	
	public List<Effector> getFoodEffectors() {
		return foodEffectors;
	}

	public void setFoodEffectors(List<Effector> foodEffectors) {
		this.foodEffectors = foodEffectors;
	}

	public STATUS getStatus() {
		return status;
	}


	public void setStatus(STATUS status) {
		this.status = status;
	}

	public void setType(TYPE type) {
		this.type = type;
	}

	public TYPE getType() {
		return this.type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String toString(){
		return "[" + this.getName() 
				+ "(Type)" + getType() 
				+ "(Status)" + getStatus()
				+ "(Effectors)" + foodEffectors.toString()
				+ "]";
	}
	
}
