package com.xai.gui.jframe.cards;

import java.util.List;

public class Rule {
	
	//return true = higher
	public static boolean match(List<Card> h1, List<Card> h2){
		if( getTotalP(h1) >= getTotalP(h2)){
			return true;
		}
		return false;
	}
	
	private static int getTotalP(List<Card> cs){
		int p = 0;
		for(Card c: cs){
			p+=c.getRank().val();
		}
		return p;
	}
}
