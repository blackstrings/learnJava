package com.xai.io.save;

public class Wep {
	
	private int id;
	private int dmg;
	private int rare;
	private String name;
	
	public Wep(int id, int dmg, int rare, String name) {
		super();
		this.id = id;
		this.dmg = dmg;
		this.rare = rare;
		this.name = name;
	}
	
	public Wep(Wep wep){
		this.id = wep.id;
		this.dmg = wep.dmg;
		this.rare = wep.rare;
		this.name = wep.name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getDmg() {
		return dmg;
	}

	public void setDmg(int dmg) {
		this.dmg = dmg;
	}

	public int getRare() {
		return rare;
	}

	public void setRare(int rare) {
		this.rare = rare;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
