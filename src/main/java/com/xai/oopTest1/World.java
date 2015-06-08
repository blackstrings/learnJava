package com.xai.oopTest1;

public abstract class World implements IWorld {

	private int clock;
	private boolean day;
	protected StringBuilder toString = new StringBuilder();
	protected String NEW_LINE = System.getProperty("line.separator");
	private String name = "";
	

	public World() {
		day = true;
		clock = 0;
		name = "noName";
	}

	public void update() {
		updateClock();
	}

	private void updateClock() {
		clock++;

		// reset clock
		if (clock > 24)
			clock = 0;

		// check day/night
		if (clock >= 20 && clock <= 24 || clock >= 0 && clock <= 8) {
			day = false;
		} else {
			day = true;
		}
	}

	public boolean getDay() {
		return day;
	}

	public int getClock() {
		return clock;
	}

	public void setName(String str) {
		name = str;
	}

	public String getName() {
		return name;
	}

	// ToString
	@Override
	public String toString() {

		toString.append("Planet: " + getName() + NEW_LINE);
		toString.append("Day: " + getDay() + NEW_LINE);
		toString.append("Time: " + getClock() + NEW_LINE);

		// String toString = "Planet: " + getName() + NEW_LINE;
		// toString += backUpStr;
		return toString.toString();
	}

	/*
	 * public String toString(String str){ toString += "Planet: " + getName() +
	 * str; return toString; }
	 */

}
