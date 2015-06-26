package com.xai.program.tiles.service;

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
	 * @param customConnectionMap can be null
	 */
	public static void processTileConnections(List<Tile> tiles){
		forwardConnection(tiles);
		backwardConnection(tiles);
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
				isSuccess = tiles.get(currId).addToBackward(currId-1);
				if(isSuccess) tiles.get(currId).setMainBackwardTileId(currId+1);
				if(!isSuccess) break; //TODO log it instead
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
				isSuccess = tiles.get(currId).addToForward(currId+1);
				//register main forward
				if(isSuccess) tiles.get(currId).setMainForwardTileId(currId+1);
				if(!isSuccess) break; //TODO log it instead
			}else{
				//connect last tile to first tile if need
				//tile.addToForward(tiles.get(0).getId());
			}
		}
	}
	
	/**
	 * Add additional connections so one tile may have more than one forward connection
	 * @param tiles
	 * @param customConnectionMap
	 */
	public static boolean processCustomForwardConnections(List<Tile> tiles, Map<Integer, List<Integer>> customConnectionMap){
		if(tiles != null && customConnectionMap != null){
			for(Entry<Integer, List<Integer>> entry : customConnectionMap.entrySet()){
				Integer key = entry.getKey();
				List<Integer> list = entry.getValue();
				for(Integer tileId : list){
					tiles.get(key).addToForward(tileId);
				}
			}
			return true;
		}
		return false;
	}
}
