package com.xai.program.rockpaper;

public class Hand {

	public enum TYPE {Rock, Paper, Sisscor}
	
	private TYPE type;
	
	public Hand(TYPE type){
		this.type = type;
	}
	
	public void setType(TYPE type){
		this.type = type;
	}
	
	public TYPE getType(){
		return this.type;
	}
	
	public String toString(){
		return type.name();
	}
}
