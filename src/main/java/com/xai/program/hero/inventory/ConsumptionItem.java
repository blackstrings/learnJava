package com.xai.program.hero.inventory;

import java.util.ArrayList;
import java.util.List;

public class ConsumptionItem extends Item{

	/**
	 * holds all the effect for this item
	 */
	private List<IEffector> effectList;

	
	/**
	 * Basic Items that effect hp
	 * @param name
	 * @param maxStack
	 */
	public ConsumptionItem(String name, int maxStack, List<IEffector> effectList){
		super(name, maxStack);
		this.effectList = effectList;
	}
	
	/**
	 * returns false if item applied effect and is empty
	 * true if there are still more stacks after applied effect
	 */
	@Override
	public boolean useOn(Object target){
		if(currStack > 0 ){	//check stack before allowing to use
			
			//loop through all effects and apply them to target
			for(int i=0; i<effectList.size(); i++){
				effectList.get(i).applyEffect(target);
			}
			
			//after all effects apply, deduct 1 qty from stack
			currStack--;
			
			//update status
			System.out.println(name + " remaining stacks: " + currStack + "/" + maxStack);
			
			//check if stack is empty after usage
			if(currStack <= 0){
				return true; //empty
			}
			
			return false;	//not yet empty
		}
		
		System.out.println("item has no stack to begin with, no effect applied");
		return true;	//empty
		
	}

	
}
