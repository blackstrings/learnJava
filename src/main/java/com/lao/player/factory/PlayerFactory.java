package com.lao.player.factory;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.lao.player.Player;

public class PlayerFactory {
	private static Random random = new Random();

	public static List<Player> generatePlayers(){
		List<Player> result = new ArrayList<Player>();

		for(PlayerNames name:PlayerNames.values()){
			Player temp=new Player(name.name(), getRandomInteger() , getRandomDouble());
			result.add(temp);
		}

		return result;
	}

	private static Integer getRandomInteger(){
		return random.nextInt(100);
	}
	private static Double getRandomDouble(){
		return random.nextDouble();
	}
}
