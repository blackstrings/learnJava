package com.xai.gui.jframe.cards;

import java.util.ArrayList;
import java.util.List;

//acts like the repo for players
//implemnt the dao so this class can be easily replaced with another
public class PlayerDaoImpl implements PlayerDao {

	List<PlayerBO> players = new ArrayList<PlayerBO>();
	
	
	@Override
	public PlayerBO getPlayer(PlayerId playerId) {
		if(hasPlayerAt(playerId.val)){
			return players.get(playerId.val);
		}
		return null;
	}

	@Override
	public void addPlayer(PlayerBO player) {
		players.add(player);
	}

	@Override
	public void removePlayer(PlayerId playerId) {
		if(hasPlayerAt(playerId.val)){
			players.remove(playerId.val);
		}
		
	}

	@Override
	public boolean hasPlayerAt(int index) {
		try{
			players.get(index);
			return true;
		}catch(IndexOutOfBoundsException e){
			return false;
		}
	}

	@Override
	public List<PlayerBO> getPlayers() {
		if(players != null){
			return players;
		}
		return null;
	}
	
	
}
