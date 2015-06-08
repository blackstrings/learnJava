package com.xai.oopTest;

public class PlanetX2 extends PlanetX {

	private int energyMultiplier = 2;

	public PlanetX2() {
		super();
		setEnergyLvl(energyLvl * energyMultiplier);
	}

	public PlanetX2(String name) {
		super(name);
		setEnergyLvl(energyLvl * energyMultiplier);
	}

	public String toString() {
		return super.toString() + " +1";
	}

}
