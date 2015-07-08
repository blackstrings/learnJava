package com.xai.json;

import org.json.JSONArray;
import org.json.JSONObject;

import com.xai.io.IOUtils;

/**
 * Loading json from file
 *
 */
public class JsonDemo2 {

	public static void main(String [] args){
	
		JSONObject obj = getJsonObject();
		//print entire json 
		//pass indent spacing amt as parameter for pretty print
		System.out.println(obj.toString(5));
		
	}
	
	//test jsonobject from hardcoded file
	public static JSONObject getJsonObject(){
		String file = ("res/files/jsonSave.txt");							//file path
		String jsonTextFromFile = IOUtils.readLargerTextFile(file, false);	//read file
		JSONObject obj = new JSONObject(jsonTextFromFile);					//convert to json
		return obj;
	}
	
	public static JSONObject getJsonObject(String path){
		String file = path;							//file path
		String jsonTextFromFile = IOUtils.readLargerTextFile(file, false);	//read file
		JSONObject obj = new JSONObject(jsonTextFromFile);					//convert to json
		return obj;
	}
	
}
