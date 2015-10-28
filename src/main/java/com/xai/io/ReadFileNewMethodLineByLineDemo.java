package com.xai.io;

/*
 * When reading a small file use FileReader
 * When reading by line on big file use BufferedReader
 */

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class ReadFileNewMethodLineByLineDemo {
	
	final static Charset ENCODING = StandardCharsets.UTF_8;
	
	public static void main(String [] args) throws IOException {
		
		/*
		 * http://www.javapractices.com/topic/TopicAction.do?Id=42
		 * in JDK 7, there are many and new ways to read/write files
		 */
	
		Path p1 = Paths.get("res/files/save.txt");
		
		String fileName = p1.toString();
		
		// read line by line into a list array
		List<String> lines = Files.readAllLines(p1, ENCODING);
		
		// spit out the list array
			//System.out.println(lines);
		for(String s : lines){
			System.out.println(s);
		}
		
	}
	
}
