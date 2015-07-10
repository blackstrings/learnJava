package com.xai.json;

import javax.xml.bind.DatatypeConverter;

import org.json.JSONObject;

//if you plan to transfer json strings over to another server
//good idea to convert json into a byteArray then into base64 string
//send over the network this string
//and when loading save data back from network
//decode the base64 string into byteArray and create a new string off of byteArray
public class JsonByteArrayDemo {

	public static void main(String [] args){
		
		//get json object from file
		JSONObject obj = JsonDemo2.getJsonObject("res/files/jsonLoot.txt");
		
		//see the json string
		String jsonString = obj.toString();
		System.out.println("Raw jsonString size : " + getSize(jsonString, "all"));
		
		//convert json string to byte
		byte[] jsonByte = jsonString.getBytes();
		
		//print the bytes to console
		//System.out.println("in bytes " + jsonByte.length + " : " + Arrays.toString(jsonByte));
		
		//convert bytes to base64String (encode)
		String base64Encoded= DatatypeConverter.printBase64Binary(jsonByte);
		System.out.println("base64String size : " + getSize(base64Encoded, "all") );
		
		//usually at this point this is where you would either encrypt or send this string
		//over a network to be saved on the server
		
		
		//when you load back the saved data into a json object
		//you want to start this process below here
		//convert base64String back to bytes (decode)
		byte[] base64Decoded = DatatypeConverter.parseBase64Binary(base64Encoded);
		
		//convert byte back to string
		
		String jsonStringDecoded = new String(base64Decoded);
		JSONObject newJson = new JSONObject(jsonStringDecoded);
		
	}
	
	/**
	 * 
	 * @param str
	 * @param type bytes, kb, mb, all
	 * @return
	 */
	private static String getSize(String str, String type){
		//test to get size of file
		long sizeInBytes = str.length();
		long sizeInKB = sizeInBytes / 1024;
		long sizeInMB = sizeInKB / 1024;
		
		if(type.toLowerCase().equals("bytes"))
			return sizeInBytes + " bytes";
		if(type.toLowerCase().equals("kb"))
			return sizeInKB + " KB";
		if(type.toLowerCase().equals("mb"))
			return sizeInMB + " MB";
		
		if(type.toLowerCase().equals("all")){
			return sizeInBytes + " bytes : " + sizeInKB + " KB : " + sizeInMB + " MB";
		}
		return null;
		//System.out.println("saveFileSize: " + sizeInBytes + "Bytes");
	}
}
