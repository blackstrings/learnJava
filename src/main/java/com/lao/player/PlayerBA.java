package com.lao.player;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PlayerBA {

	public static Map<String, Player> getPlayerMap(List<Player> players){
		Map<String, Player> map = new HashMap<String, Player>();

		for(Player player:players){
			map.put(player.getName(), player);
		}

		return map;
	}
}
