package com.xai.program.tiles.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.xai.program.tiles.model.Tile;
import com.xai.program.tiles.model.Type;

public class TilesBuilder {

	public static List<Tile> getNewTiles(int qty){
		List<Tile> tiles = new ArrayList<Tile>();
		List<Type> types = getAllPossibleTypes();
		
		for(int i=0; i<qty; i++){
			tiles.add(new Tile(i, getRandomType(types)));
		}
		
		return tiles;
	}
	
	private static List<Type> getAllPossibleTypes(){
		List<Type> allTypes = new ArrayList<Type>();
		for(Type type : Type.values()){
			allTypes.add(type);
		}
		return allTypes;
	}
	
	private static Type getRandomType(List<Type> types){
		Random rand = new Random();
		int randNum = rand.nextInt(types.size());
		return types.get(randNum);
	}

}
