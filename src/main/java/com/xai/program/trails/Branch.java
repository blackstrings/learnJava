package com.xai.program.trails;

import java.util.ArrayList;
import java.util.List;

public class Branch {

	private List<MainTile> tiles;
	private List<Integer> frontBranchIds;
	private List<Integer> backBranchIds;

	public Branch(){
		tiles = new ArrayList<MainTile>();
		frontBranchIds = new ArrayList<Integer>();
		backBranchIds = new ArrayList<Integer>();
	}
	
	public void add(MainTile tile){
		tiles.add(tile);
	}
	
	public void addFrontBranchId(int id){
		frontBranchIds.add(id);
	}

	public List<Integer> getFrontBranchIds() {
		return frontBranchIds;
	}
	
	public void setFrontBranchIds(List<Integer> frontBranchIds){
		this.frontBranchIds = frontBranchIds;
	}
	
	public void addBackBranchId(int id){
		backBranchIds.add(id);
	}

	public List<Integer> getBackBranchIds() {
		return backBranchIds;
	}

	public void setBackBranchIds(List<Integer> backBranchIds) {
		this.backBranchIds = backBranchIds;
	}

	public List<MainTile> getTiles() {
		return tiles;
	}

	public void setTiles(List<MainTile> tiles) {
		this.tiles = tiles;
	}
	

}
