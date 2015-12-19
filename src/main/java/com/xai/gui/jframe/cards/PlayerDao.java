package com.xai.gui.jframe.cards;

import java.util.List;

/**
 * Acts like a repo storage for players
 *
 */
public interface PlayerDao {
	public PlayerBO getPlayer(PlayerId playerId);
	public List<PlayerBO> getPlayers();
	public void addPlayer(PlayerBO player);
	public void removePlayer(PlayerId playerId);
	public boolean hasPlayerAt(int index);
	
}
