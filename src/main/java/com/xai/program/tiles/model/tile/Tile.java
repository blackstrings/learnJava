package com.xai.program.tiles.model.tile;

import java.util.ArrayList;
import java.util.List;

import com.xai.program.tiles.model.tileType.Type;

public class Tile {

	private int id;
	
	private Type type;
	
	private int mainFrontTileId;
	private int mainBackTileId;
	private List<Integer> frontTileIds;
	private List<Integer> backTileIds;
	
	public Tile(int id, Type type){
		this.id = id;
		this.type = type;
		frontTileIds = new ArrayList<Integer>();
		backTileIds = new ArrayList<Integer>();
	}
	
	//you do not want to hold a direct reference of another tile
	//if that tile gets deleted there will be issue,
	//instead hold the tile's id as a number would be better
	public boolean addFrontTileId(int tileId){
		if(frontTileIds != null){
			if(!frontTileIds.contains(tileId)){
				frontTileIds.add(tileId);
				return true;
			}else{
				return false;	//log that it didn't get add
			}
		}
		return false;	//log that frontTileIds is null
	}
	
	public boolean addBackTileId(int tileId){
		if(backTileIds != null){
			if(!backTileIds.contains(tileId)){
				backTileIds.add(tileId);
				return true;
			}else{
				return false;	//log that it didn't get add
			}
		}
		return false;			//log that backTileIds is null
	}
	
	//getters/setters
	public int getId() {return id;}
	public void setId(int id) {this.id = id;}
	public Type getType() {return type;}
	public void setType(Type type) {this.type = type;}
	
	public int getMainFrontTileId() {return mainFrontTileId;}
	public void setMainFrontTileId(int mainFrontTileId) {this.mainFrontTileId = mainFrontTileId;}
	public int getMainBackTileId() {return mainBackTileId;}
	public void setMainBackTileId(int mainBackTileId) {this.mainBackTileId = mainBackTileId;}

	public String toString(){return backTileIds + type.name() + getId() + frontTileIds;}
}
