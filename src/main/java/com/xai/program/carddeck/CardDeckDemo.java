package com.xai.program.carddeck;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CardDeckDemo {
	
	public static void main(String [] args){
		
		List<String> cardDeck = getNewDeck();
		shuffle(cardDeck);
		
		List<List<String>> players = getPlayers(4);
		
		int maxCardsPerPlayer = 5;
		
		int rounds = 5;
		for(int i=0; i<rounds; i++){
			if(deal(cardDeck, players, maxCardsPerPlayer)){	//deal
				showAllPlayerHands(players);
				clearAllPlayerHands(players);
				System.out.println(cardDeck.size() + " cards left...");
			}else{
				System.out.println("not enough cards");
				break;
			}
		}
	}
	
	public static enum Suit { Spades, Hearts, Diamonds, Clubs};
	
	public static enum Rank { 
		ACE(1), TWO(2), THREE(3), FOUR(4), FIVE(5), SIX(6), SEVEN(7), 
		EIGHT(8), NINE(9), TEN(10), JACK(11), QUEEN(12), KING(13);
		
		private int val;
		private Rank(int val){
			this.val = val;
		}
		public int val(){
			return val;
		}
		
	}
	
	public static List<String> getNewDeck(){
		List<String> deck = new ArrayList<String>();
		//populate the deck, for each suit, pair it with a rank, total 52
		for(Suit suit : Suit.values()){
			for(Rank rank : Rank.values()){
				deck.add(rank.name() + " of " + suit.name());
			}
		}
		return deck;
	}
	
	public static boolean deal(List<String> deck, List<List<String>> players, int maxCardsPerPlayer){
		
		if(players.size() * maxCardsPerPlayer > deck.size())
			return false;	//not enough cards
		
		for(List<String> player : players){
			//subList will take out from startIndex-endIndex, and actually strip that out from the original list
			List<String> cardViews = deck.subList(0, maxCardsPerPlayer);
			List<String> cards = new ArrayList<String>(cardViews);
			cardViews.clear();
			player.addAll(cards);
		}
		
		return true;
	}
	
	//in this case a player is a ArrayList, so it can hold cards, which cards are just strings
	public static List<List<String>> getPlayers(int numPlayers){
		List<List<String>> players = new ArrayList<List<String>>();
		for(int i=0; i<numPlayers; i++){
			players.add(new ArrayList<String>());
		}
		return players;
	}
	
	public static void showAllPlayerHands(List<List<String>> players){
		for(List<String> player : players){
			for(String card : player){
				System.out.println(card);
			}
			System.out.println("");
		}
	}
	
	public static void clearAllPlayerHands(List<List<String>> players){
		for(List<String> player : players){
			player.clear();
		}
	}
	
	public static void shuffle(List<String> deck){
		Collections.shuffle(deck);
	}
}
