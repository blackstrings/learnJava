package com.xai.program.persistence;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONObject;

import com.xai.json.JsonDemo2;

/**
 * 3 layer method where an item attribute can hold string arrays
 * @author xlao
 *
 */
public class PersistenceRespositoryAdvance {

	/*
	 * 1001, {name:"tom", 
	 * 			id:"3343", 
	 * 			items:
	 * 					[	
	 * 						"101", 
	 * 						"102"
	 * 					] 
	 * 		 }
	 */
	
	//These are pretty much like the repository of the item template blueprints
	private Map<Integer, HashMap<String, List<String>>> weaponRepository = null;
	private Map<Integer, HashMap<String, List<String>>> monsterReponsitory = null;
	
	public PersistenceRespositoryAdvance(){
		weaponRepository = new HashMap<Integer, HashMap<String, List<String>>>();
		monsterReponsitory = new HashMap<Integer, HashMap<String, List<String>>>();
		
		//test file
		String file = "src/main/java/com/xai/program/persistence/itemJson.txt";
		
		//load all items into the repositories
		loadItemTemplates(file);
	}
	
	private void loadItemTemplates(String file){
		
		//get the root json object
		JSONObject obj = JsonDemo2.getJsonObject(file);
		
		//populate the repositories which will have to explicitly be implemented
		//as you need to know what repositories to populate
		populateMap(monsterReponsitory, obj.getJSONArray("mon"));
		populateMap(weaponRepository, obj.getJSONArray("wep"));
		//...
		
	}
	
	//2 layer
	private void populateMap(Map<Integer, HashMap<String, List<String>>> masterMap, JSONArray jsArr){
		for(int i=0; i<jsArr.length(); i++){
			
			//prepare itemAttributeMap
			HashMap<String, List<String>> itemAttributeMap = new HashMap<String, List<String>>();
			List<String> attributeList = null;
			
			//get the item
			JSONObject item = jsArr.getJSONObject(i);
			
			//set item attribute to map
			String[] strs = item.getNames(item);
			for(int k=0; k<strs.length; k++){
				
				
				//check if attribute is an array
				attributeList = new ArrayList<String>();
				if(item.get(strs[k]) instanceof String ){
					
					//store the only attribute
					attributeList.add(item.getString(strs[k]));
					
				}else if(item.get(strs[k]) instanceof JSONArray){
					
					//iterate and store all attributes
					JSONArray subItems = item.getJSONArray(strs[k]);
					for(int n=0; n<subItems.length(); n++){
						
						attributeList.add(subItems.getString(n));
					}
				}
				
				itemAttributeMap.put(strs[k], attributeList);
			}
			
			//add item to master hashMap
			masterMap.put(jsArr.getJSONObject(i).getInt("id"), itemAttributeMap);
		}
	}
	
	//getters
	
	/**
	 * Here you can choose to return a hashmap or crate an object using a factory
	 * @param id
	 * @return 
	 */
	public HashMap<String, List<String>> getMonster(int id){
		return monsterReponsitory.get(id);
	}
	
	public HashMap<String, List<String>> getWeapon(int id){
		return weaponRepository.get(id);
	}

	public Map<Integer, HashMap<String, List<String>>> getWeaponRepository() {
		return weaponRepository;
	}

	public Map<Integer, HashMap<String, List<String>>> getMonsterReponsitory() {
		return monsterReponsitory;
	}
	
	
}
