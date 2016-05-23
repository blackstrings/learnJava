package com.xai.abstraction;

import java.util.ArrayList;
import java.util.List;

public class AbstractionDemo {

	public static void main(String [] args){
		
		//Cannot use animal factory yet it's more complicated 
		
		//TODO create food builder
		List<Food.TYPE> consumableFoodTypes = new ArrayList<Food.TYPE>();
		consumableFoodTypes.add(Food.TYPE.MEAT);
		consumableFoodTypes.add(Food.TYPE.FRUIT);
		
		Eagle bird = new Eagle("Berlin South Maw", 500, consumableFoodTypes);
		System.out.println(bird.toString());
		
		
		AnimalFactory af = new AnimalFactory();
		//Bird bird = af.getAnimalByType("bird");
		
		//Test actions
		//typeOf
		/*
		 * if( bird instanceof Eagle){
			((Eagle) bird).dive();
		}
		*/
		
		FoodFactory ff = new FoodFactory();
		
		///testing multiple feeds and random food
		for(int i=0; i<7; i++){
			Food randFood = ff.getRandomFood();
			bird.feed(randFood);
		}
		
		
		
		System.out.println(bird);
		bird.getIsAlive();
		
	}
	
}
