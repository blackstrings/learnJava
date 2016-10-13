package com.xai.io;

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

public class IOUtils {

	public final static Charset ENCODING = StandardCharsets.UTF_8;
	public static String readLargerTextFile(String aFileName, boolean displaySize)  {
		Path path = Paths.get(aFileName);
		
		//test to get size of file
		if(displaySize){
			long sizeInBytes = new File(aFileName).length();
			long sizeInKB = sizeInBytes / 1024;
			long sizeInMB = sizeInKB / 1024;
			System.out.println("saveFileSize: " + sizeInBytes + "Bytes");
		}
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
	
	public static void writeLargerTextFile(String aFileName, List<String> aLines) {
	    Path path = Paths.get(aFileName);
	    try (BufferedWriter writer = Files.newBufferedWriter(path, ENCODING)){
	      for(String line : aLines){
	        writer.write(line);
	        writer.newLine();
	      }
	    } catch (IOException e) {
			e.printStackTrace();
		}
	  }
	
}
