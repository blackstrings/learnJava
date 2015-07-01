package com.xai.program.trails;

import com.xai.program.tiles.model.tileType.Type;

public class TileLevelController {
	
	private Level level;

	//performs one at a time regardless of the amt
	public int[] moveForward(Marker marker){
		
		int[] newPos = level.getNextMarkerPos(marker.getCurrPos());
		
		//run logic here before accepting the actual move
		//logic - is currPos on a blockage
		/*if(isTileBlockage(newPos)){
			//what to do here
			return newPos = null;
		}
		*/
		
		//logic
		if(newPos != null){
			marker.setCurrPos(newPos);
			return newPos;
		}
		
		//logic
		
		
		System.out.println("end of branch");
		return newPos;
	}
	
	public void executeTileEvent(Marker marker){
		level.getTile(marker.getCurrPos()).executeEvent();
	}
	
	public void forceNewMarkerPos(Marker marker, int[] newPos){
		marker.setCurrPos(newPos);
	}
	
	private boolean isTileBlockage(int[] pos){
		if(level.getTile(pos).getType().equals(Type.A)){ //typeA simulates blockage
			return true;
		}
		return false;
	}
	
	//
	public Level getLevel() {
		return level;
	}
	public void setLevel(Level level) {
		this.level = level;
	}
	
}
