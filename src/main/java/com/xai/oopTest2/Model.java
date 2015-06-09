package com.xai.oopTest2;

import java.util.ArrayList;
import java.util.List;

public class Model {
	
	List<Wep> weps;

	public Model(){
		weps = new ArrayList<Wep>();
	}

	public List<Wep> getWeps() {
		return weps;
	}

	public void setWeps(List<Wep> weps) {
		this.weps = weps;
	}
	
	

}
