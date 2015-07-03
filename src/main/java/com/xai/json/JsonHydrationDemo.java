package com.xai.json;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import com.xai.gametest2.Fish;
import com.xai.gametest2.GameObject.Prop;

/**
 * json into objects
 *
 */
public class JsonHydrationDemo {

	public static void main(String [] args){
		
		//load json from file
		JSONObject jsonObject = JsonDemo2.getJsonObject();
		
		List<Fish> fishes = new ArrayList<Fish>();
		
		JSONArray arr = jsonObject.getJSONArray("fishes");
		for(int i=0; i<arr.length(); i++){
			JSONObject jsObj = (JSONObject) arr.get(i);
			
			Fish fish = new Fish();
			fish.setProp(Prop.NAME, jsObj.getString(Prop.NAME.name()));
			fish.setProp(Prop.SIZE, jsObj.getDouble(Prop.SIZE.name()));
			fish.setProp(Prop.WEIGHT, jsObj.getDouble(Prop.WEIGHT.name()));
			
			fishes.add(fish);
		}
		
		System.out.println(fishes);
		
		
		
		
	}
}
