package com.xai.gametest2;

public abstract class Rod extends Gear {

	private double length;
	
	// length of the rod, affects buoyancy when casting
	public double getLength() {
		return length;
	}

	public void setLength(double length) {
		this.length = length;
	}

}
