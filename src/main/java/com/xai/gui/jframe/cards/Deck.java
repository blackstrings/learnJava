package com.xai.gui.jframe.cards;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {

	private List<Card> cs = null;
	
	public Deck(){
		refresh();
	}
	
	public boolean canDeal(int amtNeeded){
		if(cs != null && cs.size() > amtNeeded){
			return true;
		}
		return false;
	}
	
	public List<Card> deal(int amount){
		if(canDeal(amount)){
			List<Card> hand = new ArrayList<Card>();
			for(int i=0; i<amount; i++){
				hand.add(cs.remove(i));
			}
			return hand;
		}
		return new ArrayList<Card>();
	}
	
	public Card getCard(int index){
		return cs.get(index);
	}
	
	//gets all 52 cards using enums and shuffles deck
	public void refresh(){
		cs = new ArrayList<Card>();
		for(Suit s : Suit.values()){
			for(Rank r : Rank.values()){
				cs.add(new Card(s,r));
			}
		}
		Collections.shuffle(cs);
	}
	
	public int getSize(){
		return cs.size();
	}
	
	public Card remove(int index){
		return cs.remove(index);
	}
}
