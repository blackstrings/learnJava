package com.xai.program.tiles;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.xai.program.tiles.application.TileConnector;
import com.xai.program.tiles.dao.TilesBuilder;
import com.xai.program.tiles.dao.TilesDao;
import com.xai.program.tiles.dao.TilesDaoImpl;
import com.xai.program.tiles.model.Tile;

public class TilesDemo {

	public static void main(String [] args){
		
		TilesDao tilesDao = new TilesDaoImpl();
		tilesDao.setTiles(TilesBuilder.getNewTiles(30)); //populate random tiles
		
		//customize connections
		Map<Integer, List<Integer>> customConnectionMap = new HashMap<Integer, List<Integer>>();
		customConnectionMap.put(1, Arrays.asList(8, 12));
		customConnectionMap.put(2, Arrays.asList(15,19));
		customConnectionMap.put(3, Arrays.asList(20));
		
		//process connections
		TileConnector.processTileConnections(tilesDao.getTiles(), customConnectionMap);
		
		//test
		for(Tile tile : tilesDao.getTiles()){
			System.out.print(tile + "\n");
		}
	}
}
