package com.xai.program.tiles.application;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.xai.program.tiles.model.Tile;

public class TileConnector {

	/**
	 * connects all tiles in a linear fashion 
	 * so first tile has reference to the next tile
	 * the last tile has reference to the first tile
	 * @param tiles
	 */
	public static void processTileConnections(List<Tile> tiles, Map<Integer, List<Integer>> customConnectionMap){
		forwardConnection(tiles);
		backwardConnection(tiles);
		if(customConnectionMap != null){
			processCustomForwardConnections(tiles, customConnectionMap);
		}
	}
	
	private static void backwardConnection(List<Tile> tiles){
		boolean isSuccess = true;
		List<Tile> reversedTiles = new ArrayList<Tile>(tiles);
		Collections.reverse(reversedTiles);
		
		for(Tile tile : reversedTiles){
			
			//check so first tile doesn't try to target a non-existing tile before it
			//because we are going backward
			if(tile.getId()-1 >= 0){
				//connect tile
				int currId = tile.getId();
				if(!tiles.get(currId).addToBackward(currId-1)){
					System.out.println("connection failed");
					break;	//break if fails
				}
			}else{
				//connect first tile's backward id to nothing
				//tile.connectTo(tiles.get(0).getId());
			}
		}
		reversedTiles.clear();
		
	}
	
	private static void forwardConnection(List<Tile> tiles){
		boolean isSuccess = true;
		for(Tile tile : tiles){
			
			//check so the last tile doesn't target array out of index error
			if(tile.getId()+1 < tiles.size()){
				//connect tile
				int currId = tile.getId();
				if(!tiles.get(currId).addToForward(currId+1)){
					System.out.println("connection failed");
					break;	//break if fails
				}
			}else{
				//connect last tile to first tile
				tile.addToForward(tiles.get(0).getId());
			}
		}
	}
	
	public static void processCustomForwardConnections(List<Tile> tiles, Map<Integer, List<Integer>> customConnectionMap){

		for(Entry<Integer, List<Integer>> entry : customConnectionMap.entrySet()){
			Integer key = entry.getKey();
			List<Integer> list = entry.getValue();
			for(Integer tileId : list){
				tiles.get(key).addToForward(tileId);
			}
		}
		
	}
}
