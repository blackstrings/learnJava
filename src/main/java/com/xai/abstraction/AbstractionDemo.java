package com.xai.abstraction;

import java.util.ArrayList;
import java.util.List;

public class AbstractionDemo {

	public static void main(String [] args){
		
		//TODO create food builder
		List<Food.TYPE> consumableFoodTypes = new ArrayList<Food.TYPE>();
		consumableFoodTypes.add(Food.TYPE.MEAT);
		consumableFoodTypes.add(Food.TYPE.FRUIT);
		
		Bird bird = new Eagle("Berlin South Maw", 500, consumableFoodTypes);
		
		
		
		//Test actions
		//typeOf
		if( bird instanceof Eagle){
			((Eagle) bird).dive();
		}
		
		FoodFactory ff = new FoodFactory();
		Food randFood = ff.getRandomFood();
		bird.feed(randFood);
		
		System.out.println(bird);
		bird.getIsAlive();
		
	}
	
}
