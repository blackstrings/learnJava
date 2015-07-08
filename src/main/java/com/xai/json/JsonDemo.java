package com.xai.json;

import java.io.StringWriter;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONStringer;
import org.json.JSONTokener;

public class JsonDemo {
	
	public static void main(String [] args){
		
		//crate json
		//createJsonObjectInJava();
		
		//json to string
		//jsonObjectToString();
		
		//decode json 
		//decodeJson();
		
		//decode array json
		decodeJsonArray();
		
	}
	
	/**
	 * Note this is create just one object
	 */
	private static void createJsonObjectInJava(){
		//no no, this isn't how json are created in java
		/*
		
		//for this to work you would need to create 3 different json objects
		JSONObject obj = new JSONObject();
		obj.put("name", "tom");
		obj.put("name", "kim");
		obj.put("name", "bill");
		
		*/
		
		// yes yes
		//endcode json obj
		//this is how you can insert or replace data into an jsonObj
		JSONObject obj = new JSONObject();
		obj.put("name", "tom");
		obj.put("age", new Integer(9));
		obj.put("sex", "m");
		
		System.out.print(obj);
	}

	private static void jsonObjectToString(){
		JSONObject obj = new JSONObject();
		obj.put("name", "tom");
		obj.put("age", 9);
		
		StringWriter out = new StringWriter();
		obj.write(out);
		
		String name = obj.get("name").toString();
		
		System.out.print(out.toString() + " : Name: " + name);
		
	}
	
	/**
	 * decoding single obj to json
	 */
	private static void decodeJson(){
		//when you have to hard code the string in a class, you have to use this format with the slashes
		//when you read from a file using a string builder or reader, the quotes will be auto inserted for you
		//it is best to load from a saved text json file, than manually put in / for each quotes
		//see jsonDemo2 for loading json file
		String jsonStr = "{\"name\":\"tom\"},{\"age\":\"9\"}]}";
		
		JSONObject obj = new JSONObject(jsonStr);
		
		System.out.println(obj.get("name").toString() );
		
	}
	
	/**
	 * decoding array json obj into java
	 */
	private static void decodeJsonArray(){
		//because we are not reading from a file, we have to hardcode the quotes here
		String jsonStr = "{\"weapon\":[{\"name\":\"ham\"},{\"name\":\"stick\"},{\"name\":\"ball\"}]}";
		
		
		JSONObject obj = new JSONObject(jsonStr);
		JSONArray arr = obj.getJSONArray("weapon");
		JSONObject obj2 = arr.getJSONObject(0);
		
		System.out.println(obj2.toString(5));
		
	}
	
	
	
}
