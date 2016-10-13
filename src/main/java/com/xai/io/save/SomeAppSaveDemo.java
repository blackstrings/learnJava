package com.xai.io.save;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import com.google.gson.Gson;
import com.xai.json.JsonUtils;
import com.xai.utils.Utils;

public class SomeAppSaveDemo {

	public static void main(String [] args){
		
		//test();
		
		//where to save file to and under what file name and extension
		String pathToFile = "res/files/newJsonSave.txt";
		
		//load the json object from a file
		JSONObject obj = JsonUtils.getJsonObject("res/files/jsonLoot.txt");
		
		//to string test
		//String test = obj.toString();
		
		//in java json, you have to access the array, then zero index
		//before you can get another array or json object
		JSONArray weps = obj.getJSONArray("items").getJSONObject(0).getJSONArray("wep");

		//convert json array items into real class objects and put into list
		List<Wep> wepPool = new ArrayList<Wep>();
		JSONObject wep;
		
		//iterate through the json array
		for(int i=0; i< weps.length(); i++){
			wep = weps.getJSONObject(i);
			wepPool.add(new Wep(wep.getInt("id"), 
					wep.getInt("dmg"), 
					wep.getInt("rare"), 
					wep.getString("name")));
		}
		
		//random
		List<Wep> newWepList = new ArrayList<Wep>();
		for(int i=0; i<5; i++){
			//ranom from pool
			int rand = (int)Utils.randomBetweenTwoDouble(0, wepPool.size());
			rand--;
			
			System.out.println("size: " + wepPool.size());
			System.out.println(rand);
			Wep w = new Wep(wepPool.get(rand));
			
			//random dmg
			int rand2 = (int)Utils.randomBetweenTwoDouble(1, 6);
			w.setDmg(w.getDmg() * rand2);
			//add to list
			newWepList.add(w);
		}
		
		//converting a real class and serialize into json you should use gson, a goodle json
		Gson gson = new Gson();
		String wepListString = gson.toJson(newWepList);
		
		//because you are coming from a raw list, 
		//you'll have to pack the array list into a container 
		JSONArray jarr = new JSONArray(wepListString);
		
		//put the array in a json object
		//method 1 - preffered
		JSONObject newObj = new JSONObject();
		newObj.put("weps", jarr);
		
		//method 2
		//JSONObject js = new JSONObject("{'weps':" + wepListString + "}");
		
		List<String> dataToSave = new ArrayList<String>();
		dataToSave.add(jarr.toString());
		
		
		
		SaveControllerAbs saveCtrl = new SaveControllerImpl();
		saveCtrl.save(pathToFile, dataToSave);
	}
	
	private static void test(){
		//test file
		String pathToFile = "res/files/saveInterfaceTest.txt";
		
		//test data
		List<String> dataToSave = new ArrayList<String>();
		dataToSave.add("this is data line 0");
		dataToSave.add("this is data line 1");
		dataToSave.add("this is data line 2");
		
		//save
		SaveControllerAbs saveCtrl = new SaveControllerImpl();
		saveCtrl.save(pathToFile, dataToSave);
		
		System.out.println("saving complete");
	}
}
