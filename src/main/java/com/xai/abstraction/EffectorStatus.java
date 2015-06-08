package com.xai.abstraction;

public class EffectorStatus implements Effector {
	
	private int energy;
	
	public EffectorStatus(int energy){
		setEnergy(energy);
	}
	public EffectorStatus(){
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
