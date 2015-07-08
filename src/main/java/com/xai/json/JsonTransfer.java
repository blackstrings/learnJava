package com.xai.json;

import org.json.JSONObject;

public class JsonTransfer {

	public static void main(String [] args){
		
		JSONObject obj = JsonDemo2.getJsonObject("res/files/jsonLoot.txt");
		
		System.out.println(obj.toString(5));
	}
	
}
