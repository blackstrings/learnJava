package com.xai.program.rockpaper;

public class Player {

	private Hand hand;
	private String name;
	
	public Player(String name, Hand hand){
		this.name = name;
		this.hand = hand;
	}
	
	public Hand getHand(){
		return hand;
	}
	
	public void setHand(Hand hand){
		this.hand = hand;
	}
	
	public String toString(){
		return name;
	}
	
	
}
