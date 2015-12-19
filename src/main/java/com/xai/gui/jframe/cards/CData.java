package com.xai.gui.jframe.cards;

public class CData {

	private int p = 0;

	public int getTotalPoints() {
		return p;
	}

	public void setP(int p) {
		this.p = p;
	}
	
	public void add(int p){
		this.p += p;
	}
	
}
