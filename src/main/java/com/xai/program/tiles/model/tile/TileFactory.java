package com.xai.program.tiles.model.tile;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.xai.program.tiles.model.tileType.Type;
import com.xai.program.tiles.model.tileType.TypeFactory;

/**
 * Every new tile should be unique and append a new id
 *
 */
public class TileFactory{

	public static List<Tile> getTiles(int qty){
		List<Tile> tiles = new ArrayList<Tile>();
		List<Type> types = TypeFactory.getAllPossibleTypes();
		
		for(int i=0; i<qty; i++){
			tiles.add(new Tile(i, getRandomType(types)));
		}
		return tiles;
	}
	
	private static Type getRandomType(List<Type> types){
		Random rand = new Random();
		int randNum = rand.nextInt(types.size());
		return types.get(randNum);
	}

}
