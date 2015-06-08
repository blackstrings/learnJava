package com.xai.gametest2.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.json.*;

import com.xai.gametest2.Fish;
import com.xai.gametest2.GameObject.Prop;

public class Save {

	public Save(){}
	
	//this is just to save fish, but there should be a master call to save all savable things
	//TODO plus figure out a away to only read the file once, the cache it until an actual write/save
	//TODO also only write when needed, otherwise just keep appending to the cache save obj
	public static void saveFish(Fish fish) {

		//read from file test
		String inFilePath = "res/files/jsonSave.txt";
		String outFilePath = "res/files/jsonSave.txt";	//overwrite to same file for now
		
		//TODO implement master function to save all fishes from bag or container of player
		
		//LOAD FILE
		//if jsonText is readIn from file, you don't have to worry about hardcoding in the slashes for quotes /"name/"
		//if hardcoding a jsonText or jsonStr, you have to hardcode the slashes for "name" 
		//more like if you string builder or pass it through string builder, it will convert the quote characters
		//in the string into /" for you
		String jsonText = readLargerTextFile(inFilePath);
		
		
		
		//convert main jsonText into json object
		JSONObject obj = new JSONObject(jsonText);	//this will auto format the string "name" becomes /"name/" 
		
		//Read the list - turn on if you want to see in console
		//System.out.println(obj.toString(5));		//pretty printout, 5 is equivalent to an indent
		
		
		//you must grab the object even though it may be the only object in the entire jsonString
		//grab the object by its name to test retrieve values from that object
		JSONArray jFishArr = obj.getJSONArray("fishes");
		
		//create new json and save fish info
		JSONObject jFish = new JSONObject();
		jFish.put(Prop.NAME.name(), fish.getName());
		jFish.put(Prop.SIZE.name(), fish.getProp(Prop.SIZE));
		jFish.put(Prop.WEIGHT.name(), fish.getProp(Prop.WEIGHT));
		
		//append to fish into jsonarray
		jFishArr.put(jFish);
		
		//Total fish count
		System.out.println("Total Fishes Caught: " + jFishArr.length());
		
		//System.out.println(jFish.toString(5));		//pretty print to see the jsonObject is updated
		
		//write/save modify json to new file
		//writeLargeStringToFile(outFilePath, obj.toString());
		
		//write/save modify json to same file it was read from
		writeLargeStringToFile(inFilePath, obj.toString());
		
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
	
	public static void writeLargeStringListToFile(String toFilePath, List<String> lines){
		Path toPath = Paths.get(toFilePath);
		try (BufferedWriter writer = Files.newBufferedWriter(toPath, ENCODING)){
			for(String line : lines){
				writer.write(line);
				writer.newLine();
			}
		}catch(IOException e){
			e.printStackTrace();
		}
	}
	
	public static void writeLargeStringToFile(String toFilePath, String str){
		Path toPath = Paths.get(toFilePath);
		try (BufferedWriter writer = Files.newBufferedWriter(toPath, ENCODING)){
			writer.write(str);
		}catch(IOException e){
			e.printStackTrace();
		}
	}
	
}
