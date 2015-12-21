package com.xai.gui.jframe.rp;

import org.json.JSONObject;

import com.xai.io.IOUtils;

public class RpgUtil {

	public static JSONObject getJsonObject(String path){
		String file = path;							//file path
		String jsonTextFromFile = IOUtils.readLargerTextFile(file, false);	//read file
		JSONObject obj = new JSONObject(jsonTextFromFile);					//convert to json
		return obj;
	}
	
}
