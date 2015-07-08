package com.xai.json;

import java.util.HashMap;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONObject;

//how to get inside a json array and grab attributes into a new class
public class JsonTransfer {

	//inner class to hold the json data
	static class Item{
		public String name;
		public Item(String name){
			this.name = name;
		}
	}
	
	static class User{
		private Item item;
		private String name;
		public User(String name){
			this.name = name;
		}
		public void setItem(Item item){
			this.item = item;
		}
	}
	
	public static void main(String [] args){
		
		JSONObject obj = JsonDemo2.getJsonObject("res/files/jsonLoot.txt");
		
		System.out.println(obj.toString(5));
		
		//store items
		Map<Integer, Item> itemMap = new HashMap<Integer, Item>();
		
		JSONArray jsArr = obj.getJSONArray("items").getJSONObject(0).getJSONArray("wep");
		
		//iterate through wep arrayList
		for(int i=0; i<jsArr.length(); i++){
			String name = jsArr.getJSONObject(i).get("name").toString();
			Integer id = jsArr.getJSONObject(i).getInt("id");
			Item item = new Item(name);
			itemMap.put(id, item);
		}
		
		//iterate through users
		Map<Integer, User> userMap = new HashMap<Integer, User>();
		
		jsArr = obj.getJSONArray("mon");
		for(int i=0; i<jsArr.length(); i++){
			String name = jsArr.getJSONObject(i).get("name").toString();
			Integer id = jsArr.getJSONObject(i).getInt("id");
			
			//hydrate user
			User user = new User(name);
			
			if(!jsArr.getJSONObject(i).getJSONArray("equipments").isNull(0)){
				Integer key = jsArr.getJSONObject(i).getJSONArray("equipments").getInt(0);
				user.setItem(itemMap.get(key));
			}
			
			userMap.put(id, user);
		}
		
		//save
		
	}
	
	
}
