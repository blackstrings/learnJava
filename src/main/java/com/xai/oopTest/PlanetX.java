package com.xai.oopTest;

public class PlanetX extends Planet {

	private int defaultEnergyLvl = 10;

	public PlanetX() {
		super();
		setEnergyLvl(defaultEnergyLvl);
	}

	public PlanetX(String name) {
		super(name);
		setEnergyLvl(defaultEnergyLvl);
	}

	@Override
	public String toString() {
		return "PlanetX:" + name;
	}

}
