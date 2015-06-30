package com.xai.program.trails;

public class TileLevelController {
	
	private Level level;

	//performs one at a time regardless of the amt
	public int[] moveForward(Marker marker){
		
		int[] newPos = level.getNextMarkerPos(marker.getCurrPos());
		
		//run logic here before accepting the actual move
		
		if(newPos != null){
			marker.setCurrPos(newPos);
			return newPos;
		}
		
		System.out.println("end of branch");
		return newPos;
	}
	
	public void forceNewMarkerPos(Marker marker, int[] newPos){
		marker.setCurrPos(newPos);
	}
	
	//
	public Level getLevel() {
		return level;
	}
	public void setLevel(Level level) {
		this.level = level;
	}
	
}
