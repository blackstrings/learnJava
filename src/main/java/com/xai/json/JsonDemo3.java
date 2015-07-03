package com.xai.json;

import java.util.Iterator;

import org.aspectj.org.eclipse.jdt.core.dom.rewrite.ITrackedNodePosition;
import org.json.JSONArray;
import org.json.JSONObject;

import com.xai.io.IOUtils;

/**
 * Read more into json obj arays
 *
 */
public class JsonDemo3 {

	public static void main(String [] args){
		
		//get json
		String file = ("res/files/jsonSave.txt");							//file path
		String jsonTextFromFile = IOUtils.readLargerTextFile(file, false);	//read file
		JSONObject obj = new JSONObject(jsonTextFromFile);					//convert to json
		
		//get only objects within range inside the array
		JSONObject newObj = getNewJSON(obj,"fishe", 2,5);
		
		if(newObj != null)
			System.out.println(newObj.toString(5));
		
	}
	
	/**
	 * Returns a new JSONObject with custom range from jsonArray.
	 * @param jsonArray
	 * @param min
	 * @param max
	 * @return
	 */
	public static JSONObject getNewJSON(JSONObject jsonObject, String key, int min, int max){

		//pull out one array to work with
		JSONArray jsonArray = null;
		try{
			jsonArray = jsonObject.getJSONArray(key);
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
		
		//create new json obj and array so we don't temper the original json
		//we want a new obj with queried fishes
		JSONObject newObj = new JSONObject();
		JSONArray newArr = new JSONArray();
		
		//range of index we want to pull from the array
		if(max < jsonArray.length() && min >= 0){
			
			//create an iterator, since jsonArray doesn't have one
			//set the max array size [0,1,2]
			int[] itr = new int[max-min];
			int counter = 0;
			
			//populate the iterator with the min-max values
			for(int i=0; i<itr.length; i++){
				itr[i] = min + counter;
				counter++;
			}
			
			for(int index : itr){
				newObj.put("fishes", newArr.put(jsonArray.get(index)));
			}
		}
		
		//iterate through json array (can't use the for enhance loop)
		/*
		for(int i=0; i<jsonArr.length(); i++){
			
			//grab only the in between indexes
			if(i>min && i<max){
				
				//put into the new object
				newObj.put("fishes", newArr.put(jsonArr.get(i)));
			}else if(i>=max){
				break;
			}
		}
		*/
		
		return newObj;
	}
}
