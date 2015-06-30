package com.xai.program.trails;

import java.util.ArrayList;
import java.util.List;

public class MainTile implements ITile {

	private Trail currTrail;

	public MainTile(){
		
	}

	@Override
	public void executeEvent() {
		System.out.println("event executed");
	}
	
	public Trail getCurrTrail() {
		return currTrail;
	}

	public void setTrailIndex(Trail currTrail) {
		this.currTrail = currTrail;
	}
	
}
