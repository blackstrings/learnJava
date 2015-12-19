package com.xai.gui.jframe.cards;

import java.util.List;

/**
 * responsible for accessing the business object
 */
public class CService {

	PlayerDao playerRepo;
	Deck deck;

	public CService() {
		playerRepo = new PlayerDaoImpl();
		deck = new Deck();
	}
	
	public Deck getDeck(){
		return deck;
	}
	
	public void refreshDeck(){
		deck.refresh();
	}

	public PlayerDao getPlayerRepo() {
		return playerRepo;
	}

	public void addPlayers(int numOfPlayers) {
		for (int i = 0; i < numOfPlayers; i++) {
			playerRepo.addPlayer(new PlayerBO());
		}

	}

	public void deal(PlayerId playerId, int numOfCards) {
		if(playerRepo.hasPlayerAt(playerId.val)){
			playerRepo.getPlayer(playerId).setHand(deck.deal(numOfCards));
		}else{
			System.out.println("no player id " + playerId);
		}
	}
	
	//if either player hands are empty refresh deck
	public boolean isPlayersHandsEmpty(){
		for(PlayerBO player : playerRepo.getPlayers()){
			if(player.getHand().isEmpty()){
				return true;
			}
		}
		return false;
	}
	
	public void match(PlayerId playerId1, PlayerId playerId2, int points){
		PlayerBO p1 = getPlayerRepo().getPlayer(playerId1);
		PlayerBO p2 = getPlayerRepo().getPlayer(playerId2);
		
		if(Rule.match(p1.getHand(), p2.getHand())){
			p1.add(points);
		}else{
			p2.add(points);
		}
	}

}
