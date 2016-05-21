package com.xai.property;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
 * how to grab key/value from properties file
 * Properties are good when you need simple data like key values
 * For example, loading envrionments or configs
 * Anything more complex than key values and has nested values, use json approach
 */
public class PropertiesDemo {

	public static void main(String [] args){
		
		String propertyLocation = "src/main/java/com/xai/property/SomeData.properties";	//file location
		Properties prop = new Properties();	//new properties object
		
		try {
			//get the file into stream
			FileInputStream fs = new FileInputStream(propertyLocation);
			//load the file
			prop.load(fs);													
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//get the values
		String height = prop.getProperty("height");
		
		//set the value
		int num = Integer.parseInt(height);
	}
	
}
