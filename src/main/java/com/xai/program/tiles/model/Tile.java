package com.xai.program.tiles.model;

import java.util.ArrayList;
import java.util.List;

public class Tile {

	private int id;
	private Type type;
	private List<Integer> forwardTileIds;
	private List<Integer> backwardTileIds;
	
	public Tile(int id, Type type){
		this.id = id;
		this.type = type;
		forwardTileIds = new ArrayList<Integer>();
		backwardTileIds = new ArrayList<Integer>();
	}
	
	//you do not want to hold a direct reference of another tile
	//if that tile gets deleted there will be issue,
	//instead hold the tile's id as a number would be better
	public boolean addToForward(int tileId){
		if(forwardTileIds != null){
			if(!forwardTileIds.contains(tileId)){
				forwardTileIds.add(tileId);
				return true;
			}
		}
		return false;
	}
	
	public boolean addToBackward(int tileId){
		if(backwardTileIds != null){
			if(!backwardTileIds.contains(tileId)){
				backwardTileIds.add(tileId);
				return true;
			}
		}
		return false;
	}
	
	//getters/setters
	public int getId() {return id;}
	public void setId(int id) {this.id = id;}
	public Type getType() {return type;}
	public void setType(Type type) {this.type = type;}
	
	public String toString(){
		return backwardTileIds + type.name() + getId() + forwardTileIds;
	}
}
