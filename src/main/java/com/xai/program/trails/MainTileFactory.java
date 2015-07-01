package com.xai.program.trails;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.xai.program.tiles.model.tileType.Type;
import com.xai.program.tiles.model.tileType.TypeFactory;

public class MainTileFactory {
	
	public static List<MainTile> getTiles(int qty){
		List<MainTile> tiles = new ArrayList<MainTile>();
		List<Type> types = TypeFactory.getAllPossibleTypes();
		
		for(int i=0; i<qty; i++){
			tiles.add(new MainTile(getRandomType(types)));
		}
		return tiles;
	}
	
	private static Type getRandomType(List<Type> types){
		Random rand = new Random();
		int randNum = rand.nextInt(types.size());
		return types.get(randNum);
	}
}
