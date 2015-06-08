package com.xai.io;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

/*
 * Stream I/O operations involve three steps:
 * 1 - Open an input/output stream associated with a physical device (e.g., file, network, console/keyboard), 
 * by constructing an appropriate I/O stream instance.
 * 2 - Read from the opened input stream until "end-of-stream" encountered, or write to the opened output stream (and optionally flush the buffered output).
 * 3 - Close the input/output stream.
 */
public class ReadFromFileDemo {
	
	final static Charset ENCODING = StandardCharsets.UTF_8;
	
	public static void main(String [] args) throws IOException{
		
		/*
		 * http://www.javapractices.com/topic/TopicAction.do?Id=42
		 * in JDK 7, there are many and new ways to read/write files
		 */
	
		Path p1 = Paths.get("res/files/save.txt");
		// String fileName = p1.toString();
		
		List<String> lines = Files.readAllLines(p1, ENCODING);
		
		System.out.println(lines);
		
	}
	
	
}
