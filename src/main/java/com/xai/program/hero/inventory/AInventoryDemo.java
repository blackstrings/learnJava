package com.xai.program.hero.inventory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <p>
 * For status effect, the idea is to treat each status effect as an obj.
 * </p>
 * @author xlao
 *
 */
public class AInventoryDemo {

	
	public static void main(String [] args){
		
		BasicUser h = new BasicUser(100);
		
		//longer way to create new item and give it to hero
		List<IEffector> effects = new ArrayList<IEffector>();
		effects.add(new HPEffector(10));
		int maxStack = 1;
		ConsumptionItem basicItem = new ConsumptionItem("HotDog", 1, effects);
		h.takeItem(basicItem);
		
		//shorter way to create new item and give it to hero
		h.takeItem(ItemFactory.getConsumptionItem("Poison Apple", 2));
		
		maxStack = 1;
		h.takeItem(new ToolItem("treasureKey", maxStack));
		
		//start simulation
		//-----------------------
		h.getUserStatus();
		
		h.use("HotDog",h);
		h.getUserStatus();
		
		h.use("Poison Apple", h);
		h.getUserStatus();
		
		h.use("Poison Apple", h);
		h.getUserStatus();
		
		//find treasurebox
		Box box = new Box("TreasureBox");
		h.currTarget = box;	//make hero target box
		h.use("treasureKey", h.currTarget);	//make hero use key on target box
		box.useOn(h);	//get itme from box if it is no longer lock
		
		h.use("itemNoName", h);
		h.getUserStatus();	//show hero has new item from box
		
		
	}
}
