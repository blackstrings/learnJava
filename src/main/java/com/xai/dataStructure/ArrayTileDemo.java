package com.xai.dataStructure;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;


public class ArrayTileDemo {
	
	//nested
	public static class Marker {
		
		public ArrayTileDemo tile;
		public String name = "Marker";
		
		public Marker(){
			
		}
		
		public void setTile(ArrayTileDemo tile){
			this.tile = tile;
		}
		public ArrayTileDemo getTile(){
			return this.tile;
		}
		
	}
	
	public String name;
	public String x;
	public String y;
	public List<List<ArrayTileDemo>> multiPath = new ArrayList<List<ArrayTileDemo>>();
	
	public ArrayTileDemo(String name, String x, String y){
		this.name = name;
		this.x = x;
		this.y = y;
		
	}
	public void addMultiPath(List<ArrayTileDemo> trail){
		multiPath.add(trail);
	}
	
	
	
	//testing purposes
	public static void main(String [] args){
		List<List<ArrayTileDemo>> trails = new ArrayList<List<ArrayTileDemo>>();
		
		//marker
		Marker marker = new Marker();
		
		ArrayTileDemo lt1 = new ArrayTileDemo("@1", "1", "2");
		ArrayTileDemo lt2 = new ArrayTileDemo("@2", "8", "9");
		ArrayTileDemo lt3 = new ArrayTileDemo("@3", "8", "9");
		ArrayTileDemo lt4 = new ArrayTileDemo("@4", "8", "9");
		
		ArrayTileDemo lt5 = new ArrayTileDemo("@5", "8", "9");
		
		trails.add( connectTiles(lt1, lt2) );
		
		//multi path
		trails.add( connectTiles(lt2, lt5) );
		trails.add( connectTiles(lt2, lt3) );
		
		
		trails.add( connectTiles(lt3, lt4) );
		
		
		for(int i=0; i<trails.size(); i++){
		
			for(int j=0; j<trails.get(0).size(); j++){
				System.out.print(trails.get(i).get(j).name + ", ");
			}
		}
		System.out.println();
		System.out.println("-----------------------------------------------------");
		
		List<ArrayTileDemo> currentTrail = trails.get(0);
		
		//set marker
		marker.setTile(currentTrail.get(3));
		
		
		System.out.println();
		System.out.println("Marker is at: " + marker.getTile().name);
		
		//move marker
		int roll = 8;
		
		// get currentLoc
		int currentLoc = currentTrail.indexOf(marker.getTile());
		
		// get new loc
		int newLoc = currentLoc + roll;
		
		//validate new loc if out of bound of current trail
		if(newLoc >= currentTrail.size()){
			newLoc = currentTrail.size()-1; //set to last tile of currentTrail
		}
		
		System.out.println("newLocIndex: " + newLoc);
		
		//relocate
		marker.setTile(currentTrail.get(newLoc));
		
		System.out.println("Marker is at: " + marker.getTile().name);
		
		
	}
	
	private static List<ArrayTileDemo> connectTiles(ArrayTileDemo lt1, ArrayTileDemo lt2){
	
		ArrayList<ArrayTileDemo> trail = new ArrayList<ArrayTileDemo>();
		
		trail.add(lt1);
		
		for(int i=0; i<3; i++){
			trail.add(new ArrayTileDemo("o" + i, "0", "0") );
			
		}
		
		trail.add(lt2);
		
		return trail;
	
	}
}
