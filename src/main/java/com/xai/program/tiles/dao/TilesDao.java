package com.xai.program.tiles.dao;

import java.util.List;

import com.xai.program.tiles.model.tile.Tile;

public interface TilesDao {
	public Tile getTile(int id);
	public void setTiles(List<Tile> tiles);
	public void add(Tile tile);
	public List<Tile> getTiles();
}
