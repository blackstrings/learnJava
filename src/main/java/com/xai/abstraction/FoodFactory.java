package com.xai.abstraction;

import java.util.ArrayList;
import java.util.List;

public class FoodFactory {
	public FoodFactory(){
		List<Food> foods = new ArrayList<Food>();
		
	}

	public Food getRandomFood() {
		return new Food(null, null, null, null);
	}
	
	
}
