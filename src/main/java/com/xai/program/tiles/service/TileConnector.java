package com.xai.program.tiles.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.xai.program.tiles.model.tile.Tile;

public class TileConnector {

	/**
	 * connects all tiles in a linear fashion 
	 * forward and backward
	 * @param tiles
	 * @param customConnectionMap can be null
	 */
	public static void processBasicConnections(List<Tile> tiles){
		processFrontConnections(tiles);
		processBackConnections(tiles);
	}
	
	/*
	 * the last tile has reference to the previous tileId and so on
	 * Exception: the first tile has no previous
	 */
	private static void processBackConnections(List<Tile> tiles){
		boolean isSuccess = true;
		int currId;
		for(Tile tile : tiles){
			
			//first tile don't get any backId
			if(tile.getId() != 0 && tile.getId()+1 <= tiles.size()){
				currId = tile.getId();
				tiles.get(currId).addBackTileId(currId-1);
				tiles.get(currId).setMainBackTileId(currId-1);
			}
		}
	}
	
	/*
	 * so first tile has reference to the next tileId and so on to the last tile
	 * Exception: the last tile has no front tileId
	 */
	private static void processFrontConnections(List<Tile> tiles){
		boolean isSuccess = true;
		int currId;
		for(Tile tile : tiles){
			
			//check so the last tile doesn't target array out of index error
			if(tile.getId()+1 < tiles.size()){
				currId = tile.getId();
				tiles.get(currId).addFrontTileId(currId+1);
				//register main forward
				tiles.get(currId).setMainFrontTileId(currId+1);
			}else{
				//connect last tile to first tile if need
				//tile.addToForward(tiles.get(0).getId());
			}
		}
	}
	
	/**
	 * Add additional connections 
	 * so one tile can have many front connections
	 * @param tiles
	 * @param customConnectionMap
	 */
	public static boolean addCustomFrontConnections(List<Tile> tiles, Map<Integer, List<Integer>> customConnectionMap){
		if(tiles != null && customConnectionMap != null){
			
			
			for(Entry<Integer, List<Integer>> entry : customConnectionMap.entrySet()){
				Integer key = entry.getKey();
				List<Integer> list = entry.getValue();
				
				//for each tile, add the following ids
				for(Integer tileId : list){
					tiles.get(key).addFrontTileId(tileId);
				}
			}
			return true;
		}
		return false;
	}
}
