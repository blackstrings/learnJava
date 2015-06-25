package com.xai.program.tiles.dao;

import java.util.ArrayList;
import java.util.List;

import com.xai.program.tiles.model.Tile;

public class TilesDaoImpl implements TilesDao {

	private List<Tile> tiles = new ArrayList<Tile>();
	
	@Override
	public Tile getTile(int id) {
		if(!tiles.isEmpty() && id < tiles.size()){
			return tiles.get(id);
		}
		return null;
	}

	@Override
	public void add(Tile tile) {
		tiles.add(tile);
	}

	@Override
	public void setTiles(List<Tile> tiles) {
		this.tiles = tiles;
	}

	@Override
	public List<Tile> getTiles() {
		return tiles;
	}

}
