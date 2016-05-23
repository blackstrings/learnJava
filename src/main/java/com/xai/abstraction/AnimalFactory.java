package com.xai.abstraction;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.json.JSONArray;
import org.json.JSONObject;

import com.xai.json.JsonUtils;

public class AnimalFactory {
	
	public AnimalFactory(){
		init();
	}
	
	private List<Animal> cachedAnimalTemplates = new ArrayList<Animal>();
	
	//holds pool of random indexs for later use 
	//to retreive random animal from cached
	private int maxPool = 10;
	private List<Integer> animalPool = new ArrayList<Integer>();
	
	private Random random = new Random();
	
	//Converts json data into real objects and caches it for late use
	private void init(){
		JSONObject dataJson = getData();
		cachedAnimalTemplates = hydrateTemplates(dataJson);
	}
	
	//TODO move calls like these into a service
	private JSONObject getData(){
		String dataPath = "src/main/java/com/xai/abstraction/animalJson.txt";
		return JsonUtils.getJsonObject(dataPath);
	}
	
	/**
	 * The pool of random index should already have been setup and fired
	 * Now we just pop from the random index list and make a copy off the food template that way
	 * @return
	 */
	private List<Animal> getCachedFoods(){
		//List<Animal> copy = new ArrayList<Animal>(cachedAnimalTemplates);
		return null;
	}
	
	private void resetPool(){

		for(int i=0; i<maxPool; i++){
			animalPool.add( random.nextInt( cachedAnimalTemplates.size() ));
		}
	}
	
	public Animal getRandomAnimal(){

		if(animalPool.size() <= 0){
			resetPool();
		}
		
		//pop the random index from pool
		//get copy the food obj from the cached template
		Animal f = cachedAnimalTemplates.get( animalPool.remove(0));
		
		//find the correct class to cast to and return it
		//Animal copyFood = new Animal(f);
		
		return null;
	}
	
	/**
	 * Turn json data into real objects and caches it into a pool
	 * for later use
	 * @param json
	 * @return
	 */
	private List<Animal> hydrateTemplates(JSONObject json){
		List<Animal> animals = new ArrayList<Animal>();
		
		List<JSONArray> jsArr = new ArrayList<JSONArray>();
		
		JSONArray arr = json.getJSONArray("birds");
		
		//loop through json array of foods
		for(int i=0; i<arr.length(); i++){
			JSONObject foodJsObj = (JSONObject) arr.get(i);
			
			//TODO create food builder
			List<Food.TYPE> consumableFoodTypes = new ArrayList<Food.TYPE>();
			consumableFoodTypes.add(Food.TYPE.MEAT);
			consumableFoodTypes.add(Food.TYPE.FRUIT);
			
			Eagle bird = new Eagle("Berlin South Maw", 500, consumableFoodTypes);
			
			//create the real obj
			/*
			Animal newAnimal = new Animal(foodJsObj.getString("name"), 
					//effectors, 
					getEffectors(foodJsObj), 
					getStatus(foodJsObj), 
					Food.TYPE.FRUIT);
			*/
			
			
			animals.add(bird);
		}
		
		return animals;
	}
	
	//get food status, raw, spoil, etc
	private Food.STATUS getStatus(JSONObject foodJsObj){
		String type = foodJsObj.getString("status");
		
		//loop though all the statuses, if match, return that status
		for(Food.STATUS stat : Food.STATUS.values()){
			if(stat.name().toLowerCase().equals(type)){
				return stat;
			}
		}
		
		System.out.println("food data " 
				+ foodJsObj.getString("name") + " status did not match for"
				+ foodJsObj.getString("status"));
		
		return null;
	}
	
	private List<Effector> getEffectors(JSONObject foodJsObj){
		
		List<Effector> effectors = new ArrayList<Effector>();
		
		//get all effectors on this food obj
		JSONArray arr = foodJsObj.getJSONArray("effectors");

		//add each effector to effectors
		for(int i=0; i<arr.length(); i++){
			
			JSONObject effectorJsObj = (JSONObject) arr.get(i);
			
			//crate effector
			if(effectorJsObj.getString("type").equals("hp")){
				//convert
				int amt = Integer.parseInt( effectorJsObj.getString("amt") );
				//create effector
				effectors.add(new EffectorHP(amt));
				
			}else if(effectorJsObj.getString("type").equals("status")){
				int amt = Integer.parseInt( effectorJsObj.getString("amt") );
				effectors.add(new EffectorStatus(amt));
			}
			
		}
		
		return effectors;
	}
	
}
