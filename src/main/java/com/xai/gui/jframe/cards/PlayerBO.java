package com.xai.gui.jframe.cards;

import java.util.ArrayList;
import java.util.List;

public class PlayerBO {

	private List<Card> hand;
	
	public PlayerBO(){
		hand = new ArrayList<Card>();
	}
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
	
	public List<Card> getHand(){
		List<Card> temp = new ArrayList<Card>(hand);
		return temp;
	}
	
	public void setHand(List<Card> cs){
		hand = cs;
	}
	
}
