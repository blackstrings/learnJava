package com.xai.program.persistenceII.service;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import com.xai.program.persistenceII.model.Entity;
import com.xai.program.persistenceII.model.GameObject.Prop;

public class EntityFactory {

	public static Entity getEntity(Map<Integer, HashMap<String, List<String>>> allEntity){
		
		//iterate through all enity in dao and get pool mon ids
		List<Integer> ids = new ArrayList<Integer>();
		for(Integer key : allEntity.keySet()){
			ids.add(key);
		}
		
		//random id to get random mon
		Random rand = new Random();
		int randNum = rand.nextInt(ids.size());
		HashMap<String, List<String>> entityMap = allEntity.get(ids.get(randNum));
		
		//we use get[0] because every element is in an array
		//if you know certain attributes have more item, it is up to you to handle those attributes, explicitly use a for loop
		String name = entityMap.get("name").get(0);
		int id = Integer.parseInt(entityMap.get("id").get(0));
		int min = Integer.parseInt(entityMap.get("minDmg").get(0));
		int max = Integer.parseInt(entityMap.get("maxDmg").get(0));
		int randDmg = rand.nextInt(max-min) + min;
		
		//prep actual stats
		EnumMap<Prop, Object> properties = new EnumMap<Prop, Object>(Prop.class);
		properties.put(Prop.NAME, name);
		properties.put(Prop.ID, id);
		properties.put(Prop.DMG, randDmg);
		
		//new mon
		Entity entity = new Entity();
		entity.setPropertyMap(properties);
		
		return entity;
	}
	
}
