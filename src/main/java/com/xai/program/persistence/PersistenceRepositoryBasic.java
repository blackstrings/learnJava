package com.xai.program.persistence;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONObject;

import com.xai.json.JsonDemo2;

/**
 * 2 layer method where item's attributes don't carry arrays
 * @author xlao
 *
 */
public class PersistenceRepositoryBasic {

	/*
	 * 1001, {name:"tom", id:"3343", info:"def"}
	 */
	private Map<Integer, HashMap<String,String>> wep;
	private Map<Integer, HashMap<String,String>> food;
	
	public PersistenceRepositoryBasic(){
		wep = new HashMap<Integer, HashMap<String,String>>();
		food = new HashMap<Integer, HashMap<String,String>>();
		//load all items
		loadItemTemplates();
	}
	
	private void loadItemTemplates(){
		//test file
		String file = "src/main/java/com/xai/program/persistence/itemJson.txt";
		
		//get the json
		JSONObject obj = JsonDemo2.getJsonObject(file);
		
		//populate the master maps
		populateMap(wep, obj.getJSONArray("wep"));
		populateMap(food, obj.getJSONArray("food"));
		
	}
	
	//2 layer
	private void populateMap(Map<Integer, HashMap<String, String>> wep2, JSONArray jsArr){
		for(int i=0; i<jsArr.length(); i++){
			
			//itemAttributeMap
			HashMap<String, String> itemAttributeMap = new HashMap<String, String>();
			
			//get the item
			JSONObject item = jsArr.getJSONObject(i);
			
			//set item attribute to map
			String[] strs = item.getNames(item);
			for(int k=0; k<strs.length; k++){
				itemAttributeMap.put(strs[k],item.getString(strs[k]));
			}
			
			//add item to master hashMap
			wep2.put(jsArr.getJSONObject(i).getInt("id"), itemAttributeMap);
		}
	}
	
	//getters
	
	
	
}
