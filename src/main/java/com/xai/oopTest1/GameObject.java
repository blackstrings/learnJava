package com.xai.oopTest1;

public abstract class GameObject {
	
	public TYPE t;
	public enum TYPE{
		ITEM, PLAYER, AI;
	}

	public GameObject(TYPE t){
		this.t = t;
	}
	
	public TYPE getType(){
		return t;
	}
	
	@Override
	public String toString(){
		return "gameobject > " + t + " > ";
	}
	
	
}
