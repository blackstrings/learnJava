package com.xai.oopTest;

public abstract class Planet implements IWorld {

	protected String name;
	protected int energyLvl = 0;
	protected double size = 100;

	public Planet() {
		this.name = "PlanetNoName";
	}

	public Planet(String name) {
		this.name = name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return this.name;
	}

	public void setEnergyLvl(int lvl) {
		energyLvl = lvl;
	}

	public int getEnergyLvl() {
		return this.energyLvl;
	}

	public void setSize(double size) {
		this.size = size;
	}

	public double getSize() {
		return this.size;
	}

	// toString always at the bottom

	public abstract String toString();

}
