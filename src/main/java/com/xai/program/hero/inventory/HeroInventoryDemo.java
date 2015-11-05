package com.xai.program.hero.inventory;

import java.util.Random;

public class HeroInventoryDemo {

	
	public static void main(String [] args){
		
		Hero h = new Hero(100);
		
		//longer way to create new item and give it to hero
		int hpEffectorAmt = 20;
		int maxStack = 1;
		ComsumptionItem basicItem = new ComsumptionItem("HotDog", hpEffectorAmt, maxStack);
		h.takeItem(basicItem);
		
		//shorter way to create new item and give it to hero
		hpEffectorAmt = -50;
		maxStack = 2;
		h.takeItem(new ComsumptionItem("Poison Apple", hpEffectorAmt, maxStack));
		
		hpEffectorAmt = 0;
		maxStack = 1;
		h.takeItem(new ToolItem("treasureKey", hpEffectorAmt, maxStack));
		
		//start simulation
		//-----------------------
		h.getStatus();
		
		h.use("HotDog",h);
		h.getStatus();
		
		h.use("Poison Apple", h);
		h.getStatus();
		
		h.use("Poison Apple", h);
		h.getStatus();
		
		//find treasurebox
		Box box = new Box("TreasureBox");
		h.currTarget = box;	//make hero target box
		h.use("treasureKey", h.currTarget);	//make hero use key on target box
		box.useOn(h);	//get itme from box if it is no longer lock
		
		h.getStatus();	//show hero has new item from box
		
		h.use("Drink", h);	//use the new item got
		h.getStatus();			//show hero status that item was applied
		
	}
}
