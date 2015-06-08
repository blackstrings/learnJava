package com.xai.abstraction;

public class EffectorHP implements Effector {
	
	private int energy;
	
	public EffectorHP(int energy){
		setEnergy(energy);
	}
	public EffectorHP(){
		setEnergy(10);
	}
	
	/**
	 * return generic type
	 * @return 
	 */
	public <E> void effect(E x){
		if(x instanceof Animal){
			Animal animal = (Animal) x;
			animal.setHp( animal.getHp() + getEnergy() );
		}
	}

	public int getEnergy() {
		return energy;
	}

	public void setEnergy(int energy) {
		this.energy = energy;
	}
	
	public String toString(){
		return getClass().getSimpleName() + "(Engery)" + getEnergy();
	}
	
}
