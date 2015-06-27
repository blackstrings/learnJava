package com.xai.program.tiles.model.level;

import java.util.List;

import com.xai.program.tiles.dao.TilesDao;
import com.xai.program.tiles.dao.TilesDaoImpl;
import com.xai.program.tiles.model.tile.Tile;
import com.xai.program.tiles.model.tile.TileFactory;
import com.xai.program.tiles.service.TileConnector;

public class Level {
	
	private int tileQty = 0;
	private int id;
	
	//access to all the available tiles in this level
	private TilesDao tilesDao;
	
	public Level(int tileQty, int level){
		this.tileQty = tileQty;
		this.id = level;
		init();
	}
	
	private void init(){
		tilesDao = new TilesDaoImpl();
		tilesDao.setTiles(TileFactory.getTiles(tileQty)); //populate random tiles
		List<Tile> tiles = tilesDao.getTiles();
		
		//process connections
		TileConnector.processBasicConnections(tiles);
		TileConnector.addCustomFrontConnections(tiles, LevelMapFactory.getMap(id));
		
		
		//test
		
		for(Tile tile : tilesDao.getTiles()){
			System.out.print(tile + "\n");
		}
		
	}
}
