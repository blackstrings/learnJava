package com.xai.program.hero.inventory;

import java.util.Random;

public class HeroInventoryDemo {

	
	public static void main(String [] args){
		
		Hero h = new Hero(100);
		
		//longer way to create new item and give it to hero
		int hpEffectorAmt = 20;
		int maxStack = 1;
		BasicItem basicItem = new BasicItem("HotDog", hpEffectorAmt, maxStack);
		h.takeItem(basicItem);
		
		//shorter way to create new item and give it to hero
		hpEffectorAmt = -50;
		maxStack = 2;
		h.takeItem(new BasicItem("Poison Apple", hpEffectorAmt, maxStack));
		
		//start simulation
		h.getStatus();
		
		h.consume();
		h.getStatus();
		
		h.consume();
		h.getStatus();
		
		h.consume();
		h.getStatus();
		
	}
}
