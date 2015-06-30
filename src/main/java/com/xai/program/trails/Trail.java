package com.xai.program.trails;

import java.util.ArrayList;
import java.util.List;

import com.xai.program.trails.MainTile;

public class Trail {

	private List<MainTile> mainTiles;
	
	public Trail(){
		mainTiles = new ArrayList<MainTile>();
	}
	public void add(MainTile mainTile){
		mainTiles.add( mainTile);
	}
	
	//setters/getters
	public List<MainTile> getMainTiles() {
		return mainTiles;
	}
	public void setMainTiles(List<MainTile> mainTiles) {
		this.mainTiles = mainTiles;
	}
	
}
