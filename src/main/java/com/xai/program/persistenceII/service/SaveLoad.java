package com.xai.program.persistenceII.service;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import com.xai.program.persistenceII.model.Entity;
import com.xai.program.persistenceII.model.GameObject.Prop;

public class SaveLoad {

	private static String inFilePath = "src/main/java/com/xai/program/persistenceII/jsonSave.txt";
	
	public static void save(){
		JSONObject obj = new JSONObject();		//root
		
		//put as many task as you want here
		saveMons(obj);
		
		writeLargeStringToFile(inFilePath, obj.toString());
	}
	
	private static void saveMons(JSONObject obj){
		List<Entity> mons = PersistentState.getInstance().getMons();
		
		JSONArray monArr = new JSONArray();
		

		//Entity mon = mons.get(0);
		for(Entity mon : mons){
			//custom save attributes
			//when saving, you want to create a new complete different file and overwrite the old
			//do not read from the old and append to it, as this paves way for cheating files
			//save obj to json
			
			JSONObject monObj = new JSONObject();
			monObj.put(Prop.NAME.name(), mon.getProp(Prop.NAME));
			monObj.put(Prop.DMG.name(), mon.getProp(Prop.DMG));
			monObj.put(Prop.ID.name(), mon.getProp(Prop.ID));
			monArr.put(monObj);
		}
		
		obj.put("mons", monArr);
		
	}
	
	public final static Charset ENCODING = StandardCharsets.UTF_8;
	
	//write to file
	public static void writeLargeStringToFile(String toFilePath, String str){
		Path toPath = Paths.get(toFilePath);
		try (BufferedWriter writer = Files.newBufferedWriter(toPath, ENCODING)){
			writer.write(str);
		}catch(IOException e){
			e.printStackTrace();
		}
	}
	
	//read saved json file
	public static String readLargerTextFile(String aFileName)  {
		Path path = Paths.get(aFileName);
		
		//test to get size of file
		long sizeInBytes = new File(aFileName).length();
		long sizeInKB = sizeInBytes / 1024;
		long sizeInMB = sizeInKB / 1024;
		System.out.println("saveFileSize: " + sizeInBytes + "Bytes");
		//end of test for file size
		
		StringBuilder sb = new StringBuilder();
		try (BufferedReader reader = Files.newBufferedReader(path, ENCODING)){
			String line = null;
			while ((line = reader.readLine()) != null) {
				//process each line in some way
				sb.append(line);
			}      
		} catch (IOException e) {
			e.printStackTrace();
		}
		return sb.toString();
	}
	
	public static void load(){
		//load saved file
		String jsonText = readLargerTextFile(inFilePath);
		//convert main jsonText into json object
		JSONObject obj = new JSONObject(jsonText);	//this will auto format the string "name" becomes /"name/" 
		
		//load tasks put as many as you need here
		loadMons(obj);
		
		
		//PersistentState.getInstance().setMons(mons);
	}
	
	public static void loadMons(JSONObject obj){
		JSONArray monArr = obj.getJSONArray("mons");
		PersistentState state = PersistentState.getInstance();
		
		List<Entity> mons = new ArrayList<Entity>();
		for(int i=0; i<monArr.length(); i++){
			JSONObject mon = monArr.getJSONObject(i);
			Entity entity = new Entity();
			entity.setProp(Prop.NAME, mon.get(Prop.NAME.name()));
			entity.setProp(Prop.DMG, mon.get(Prop.DMG.name()));
			entity.setProp(Prop.ID, mon.get(Prop.ID.name()));
			
			mons.add(entity);
		}
		
		state.setMons(mons);
	}
}
