package com.xai.program.hero.inventory;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ItemFactory {
	
	public static Item getConsumptionItem(String name, int maxStack){
		ConsumptionItem item = getConsumptionItem();
		item.setName(name);
		
		if(maxStack == 0){
			maxStack = 1;
		}
		item.setMaxStack(maxStack);
		item.resetStack();
		
		//inverse the hp if for negative effect if has poison
		if(name.toLowerCase().contains("poison")){
			//TODO not yet implented so all hp are positive
		}
		return item;
	}

	public static ConsumptionItem getConsumptionItem(){
		
		List<IEffector> effectList = new ArrayList<IEffector>();
		
		Random rand = new Random();
		boolean addHPEffector = rand.nextBoolean();
		if(addHPEffector){
			effectList.add(new HPEffector(rand.nextInt(50)));
		}
		
		//always add status if hpeffect wasn't added
		boolean addStatusEffector = rand.nextBoolean();
		if(!addHPEffector || addStatusEffector){
			StatusType statusType;
			switch(rand.nextInt(3)){
				case 1:
					statusType = StatusType.BLIND;
					break;
				case 2:
					statusType = StatusType.CONFUSE;
					break;
				default:
					statusType = StatusType.PARALYZE;
			}
			effectList.add(new StatusEffector(statusType));
		}
		
		return new ConsumptionItem("itemNoName", 1, effectList);
		
	}
	
}
