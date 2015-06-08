package com.xai.oopTest1;

public class PlanetX extends World {

	private int MAXLEVEL = 5;
	private int curLvl = 1;

	public PlanetX() {

	}

	public PlanetX(String planetName) {
		setName(planetName);
	}

	/*
	 * Level
	 */

	public void setLvl(int lvl) {
		curLvl = lvl;
	}

	public int getLvl() {
		return curLvl;
	}

	public void increaseLvl() {
		if (curLvl < MAXLEVEL) {
			curLvl++;
		}
	}
	
	public int addLvl(){
		
		curLvl++;
		
		return curLvl;
	}

	@Override
	public String toString() {
		toString.append("CurLvl: " + getLvl() + NEW_LINE);
		return super.toString();
	}

}