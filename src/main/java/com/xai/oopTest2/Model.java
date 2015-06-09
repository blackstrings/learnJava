package com.xai.oopTest2;

import java.util.ArrayList;
import java.util.List;

public class Model {
	
	List<Wep> weps;
	String name;
	
	public Model(String name){
		this.name = name;
		weps = new ArrayList<Wep>();
	}

	public List<Wep> getWeps() {
		return weps;
	}

	public void setWeps(List<Wep> weps) {
		this.weps = weps;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	

}
