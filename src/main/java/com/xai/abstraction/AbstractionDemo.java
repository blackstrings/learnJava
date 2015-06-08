package com.xai.abstraction;

import java.util.ArrayList;
import java.util.List;

public class AbstractionDemo {

	public static void main(String [] args){
		
		//TODO create food builder
		List<Food.TYPE> consumableFoodTypes = new ArrayList<Food.TYPE>();
		consumableFoodTypes.add(Food.TYPE.MEAT);
		consumableFoodTypes.add(Food.TYPE.FRUIT);
		
		Bird bird = new Eagle("Berlin South Maw", 100, consumableFoodTypes);
		
		//TODO create effector builder
		List<Effector> effectors = new ArrayList<Effector>();
		effectors.add(new EffectorHP(-110));
		effectors.add(new EffectorStatus(-10));
		
		Food food = new Food("Rare Fruit", effectors, Food.STATUS.RAW, Food.TYPE.FRUIT);
		
		//Test actions
		//typeOf
		if( bird instanceof Eagle){
			((Eagle) bird).dive();
		}
		bird.feed(food, bird);
		System.out.println(bird);
		bird.getIsAlive();
		
	}
	
}
