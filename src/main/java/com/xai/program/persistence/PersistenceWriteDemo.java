package com.xai.program.persistence;

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
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.json.JSONArray;
import org.json.JSONObject;

//reading from presistence repo and saving modify objects
public class PersistenceWriteDemo {

	//object class
	static class Mon{

		public Mon(String name, int dmg, int id){
			this.name = name;
			this.dmg = dmg;
			this.id = id;
		}
		private String name;
		private int id;
		private int dmg;
		public int getId(){return id;}
		public int getDmg(){return dmg;}
		public String getName(){return name;}
	}
	
	//factory
	static class MonFactory{
		private static PersistenceRespositoryAdvance repoAdvance;
		
		public MonFactory(){
			//populate repo
			repoAdvance = new PersistenceRespositoryAdvance();
		}
		
		public Mon getRandomMon(){
			//testId
			int testId = 9005;
			
			//iterate through all mons and get pool mon ids
			Map<Integer,HashMap<String,List<String>>> monRepo = repoAdvance.getMonsterReponsitory();
			List<Integer> ids = new ArrayList<Integer>();
			for(Integer key : monRepo.keySet()){
				ids.add(key);
			}
			
			//random id to get random mon
			Random rand = new Random();
			int randNum = rand.nextInt(ids.size());
			HashMap<String, List<String>> monMap = repoAdvance.getMonster(ids.get(randNum));
			
			//we use get[0] because every element is in an array
			//if you know certain attributes have more item, it is up to you to handle those attributes, explicitly use a for loop
			String name = monMap.get("name").get(0);
			int id = Integer.parseInt(monMap.get("id").get(0));;
			int min = Integer.parseInt(monMap.get("minDmg").get(0));;
			int max = Integer.parseInt(monMap.get("maxDmg").get(0));;
			int randDmg = rand.nextInt(max-min) + min;
			
			//new mon
			Mon mon = new Mon(name, randDmg, id);
			
			return mon;
		}
	}
	
	public final static Charset ENCODING = StandardCharsets.UTF_8;
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
	
	public static void writeLargeStringToFile(String toFilePath, String str){
		Path toPath = Paths.get(toFilePath);
		try (BufferedWriter writer = Files.newBufferedWriter(toPath, ENCODING)){
			writer.write(str);
		}catch(IOException e){
			e.printStackTrace();
		}
	}
	
	
	public static void main(String [] args){
		
		//this is just for one type of obj
		//a more preferred way would be to loop through arrays
		//and build a json, putting jsonArrays into the main json object
		//then write the final built json to file
		
		//init persistence dao
		MonFactory factory = new MonFactory();
		//get mon from dao
		Mon mon = factory.getRandomMon();
		
		saveMon(mon);
		
	}
	
	private static void saveMon(Mon mon){
		//when saving, you want to create a new complete different file and overwrite the old
		//do not read from the old and append to it, as this paves way for cheating files
		//save obj to json
		JSONObject obj = new JSONObject();		//root
		JSONObject monObj = new JSONObject();
		JSONArray monArr = new JSONArray();

		//custom save attributes
		monObj.put("name", mon.getName());
		monObj.put("dmg", Integer.toString(mon.getDmg()));
		monObj.put("id", Integer.toString(mon.getId()));
		monArr.put(monObj);
		obj.put("mons", monArr);
		
		String inFilePath = "src/main/java/com/xai/program/persistence/itemJsonSave.txt";
		writeLargeStringToFile(inFilePath, obj.toString());
	}
	
}
