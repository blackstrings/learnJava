package com.xai.abstraction;

import java.util.List;

public abstract class Animal implements IMortal, ICanFeed {
	
	private String name;
	private int hp;
	private boolean isAlive = true;
	private List<Food.TYPE> consumableFoodTypes;
	
	public Animal(String name, int hp, List<Food.TYPE> consumableFoodTypes){
		this.setName(name);
		this.setHp(hp);
		this.setConsumableFoodTypes(consumableFoodTypes);
	}
	
	@Override
	public <E> void feed(Food food, E animal){
		System.out.println( getName() + " is feeding on " + food.toString());
		if(canConsume(food)){
			applyEffects(food.applyEffects(), (Animal)animal);
		}
	}
	
	private boolean canConsume(Food food){
		for(Food.TYPE foodType : getConsumableFoodTypes()){
			if(foodType.equals(food.getType())){
				return true;
			}
		}
		return false;
	}
	
	//loop through all effectors
	private void applyEffects(List<Effector> foodEffectors, Animal animal){
		for(Effector effector : foodEffectors){
			if(effector instanceof EffectorHP || effector instanceof EffectorStatus){
				effector.effect(animal);
			}
		}
	}
	
	@Override
	public boolean getIsAlive(){
		if( getHp() <= 0){
			System.out.println( getName() + " is Dead...");
		}
		return isAlive;
	}
	@Override
	public void setIsAlive(boolean isAlive){
		this.isAlive = isAlive;
	}
	
	public int getHp() {
		return hp;
	}

	public void setHp(int hp) {
		this.hp = hp;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Food.TYPE> getConsumableFoodTypes() {
		return this.consumableFoodTypes;
	}

	public void setConsumableFoodTypes(List<Food.TYPE> consumableFoodTypes) {
		this.consumableFoodTypes = consumableFoodTypes;
	}
	
	@Override
	public String toString(){
		return "[Animal:(Name)" + getName() + "(HP)" + getHp() + "]";
	}
	
}
