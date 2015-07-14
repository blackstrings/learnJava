package com.xai.program.tiles.model.level;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LevelMapFactory {
	
	public static Map<Integer, List<Integer>> getMap(int id){
		//customize connections
		Map<Integer, List<Integer>> customLevelMap = new HashMap<Integer, List<Integer>>();
		
		switch (id) {
			case 1:
				//you have to know in advance the tileIds you want to connect to
				customLevelMap.put(1, Arrays.asList(8, 12));
				customLevelMap.put(2, Arrays.asList(15,19));
				customLevelMap.put(3, Arrays.asList(20));
				break;
			default:
				customLevelMap = null;
				break;
		}
		return customLevelMap;
	}
}