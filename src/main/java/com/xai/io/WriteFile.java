package com.xai.io;
/*
 * Basic setup to write to a existing file.
 */

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

/**
 * This class will create a new txt file if the file doesn't exist
 * @author xlao
 *
 */
public class WriteFile {

	final static Charset ENCODING = StandardCharsets.UTF_8;
	private static String fileOut = "res/files/WriteFile.txt";
	
	public static void main(String [] args) {
		
		try{
			Path path = Paths.get(fileOut);		// get file path
			
			// populate array string with values
			List<String> lines = Arrays.asList(
					"WriteFile test 1 array[1]",			
		    		"WriteFile test 2 array[2]");
			
			Files.write(path, lines, ENCODING);
			
			//If you have multiple writes to do
			/*
			Files.write(path1, lines, ENCODING);
			Files.write(path2, lines, ENCODING);
			Files.write(path3, lines, ENCODING);
			*/
			
		}catch(IOException e){
			e.printStackTrace();
		}
		
		System.out.println("file write complete");
	}

	
}
