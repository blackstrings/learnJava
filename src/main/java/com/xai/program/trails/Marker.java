package com.xai.program.trails;

public class Marker {
	private int[] currPos; //[0,0] branch,tile

	public Marker(){}

	public int[] getCurrPos() {
		return currPos;
	}

	public void setCurrPos(int[] currPos) {
		this.currPos = currPos;
	}
	
	public String toString(){
		return "" + currPos[0] + "," + currPos[1];
	}
}
