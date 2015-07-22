package com.xai.program.persistenceII.service;

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
public class EntityTemplateRepoFactory {

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

	private static String file = "src/main/java/com/xai/program/persistenceII/jsonDB.txt";
	
	public static Map<Integer, HashMap<String, List<String>>> getMonRepo(){
		
		//prep
		Map<Integer, HashMap<String, List<String>>> monsterRepository = 
				monsterRepository = new HashMap<Integer, HashMap<String, List<String>>>();
		
		//read in file to json boj
		JSONObject obj = JsonDemo2.getJsonObject(file);
		
		//get the target json array into hashmap
		populateMap(monsterRepository, obj.getJSONArray("mon"));
		
		return monsterRepository;
	}

	//2 layer
	private static void populateMap(Map<Integer, HashMap<String, List<String>>> masterMap, JSONArray jsArr){
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

}
