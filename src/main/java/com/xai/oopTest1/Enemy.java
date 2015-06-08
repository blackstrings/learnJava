package com.xai.oopTest1;

public abstract class Enemy extends GameObject {

	private int hp;
	private String name;

	public Enemy(int hp, String name) {
		super(GameObject.TYPE.AI);
		this.hp = 100;
		this.name = name;
	}

	public int getHp() {
		return hp;
	}

	public void setHp(int hp) {
		this.hp = hp;
	}
	
	public String getName(){
		return name;
	}
	
	public void setName(String name){
		this.name = name;
	}
	
	public String toString(){
		String str = super.toString();
		return str + "Enemy > ";
	}

}
