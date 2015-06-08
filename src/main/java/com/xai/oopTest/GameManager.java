package com.xai.oopTest;

import java.util.ArrayList;

public class GameManager implements IGameObject {

	ArrayList<Planet> planets;
	NameGenerator nameGenerator;

	public GameManager() {
		planets = new ArrayList<Planet>();
		nameGenerator = new NameGenerator();
	}

	public void addPlanet(Planet planet) {
		planets.add(planet);
	}

	public ArrayList<Planet> getPlanets() {
		return planets;
	}

	public void printPlanets() {
		for (Planet p : planets) {
			System.out.println(p);
		}
	}

}
