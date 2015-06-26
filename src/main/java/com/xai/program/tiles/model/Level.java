package com.xai.program.tiles.model;

import com.xai.program.tiles.dao.TilesBuilder;
import com.xai.program.tiles.dao.TilesDao;
import com.xai.program.tiles.dao.TilesDaoImpl;
import com.xai.program.tiles.service.LevelMaps;
import com.xai.program.tiles.service.TileConnector;

public class Level {
	
	private int tileQty = 0;
	private int level;
	private TilesDao tilesDao;
	
	public Level(int tileQty, int level){
		this.tileQty = tileQty;
		this.level = level;
		load();
	}
	
	private void load(){
		tilesDao = new TilesDaoImpl();
		tilesDao.setTiles(TilesBuilder.getNewTiles(tileQty)); //populate random tiles
		
		//process connections
		TileConnector.processTileConnections(tilesDao.getTiles());
		boolean success = TileConnector.processCustomForwardConnections(tilesDao.getTiles(), LevelMaps.getCustomLevelMap(level));
		if(!success) System.out.println("custom connection failed");
		
		//test
		for(Tile tile : tilesDao.getTiles()){
			System.out.print(tile + "\n");
		}
	}
}
