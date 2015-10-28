package com.xai.io;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

/**
 * Using scanner.
 * Scanner class not really good at reading char by char.
 * You are better off using inputstream to read by char.
 *
 */
public class ReadFileOldMethodLineByLine {

	//when reading file you must handle IO exceptions
	//If a file is not found, the JVM will throw an IO exception type
	//therefore because this main method is going to be handling reading in a file
	//we will make main method handle the exception by saying
	//throws FileNotFoundException or you can throw the parent expetion IOException
	public static void main(String [] args) throws IOException{
		
		//the file path
		//feel free to replace the path value to your specific txt file if you want too
		String textFilePath = "res/files/test.txt";	
		
		File fileIn = new File(textFilePath);	//create the file object by passing in the file path
				
		Scanner scan = new Scanner(fileIn);		//pass in the file to scanner
		
		//now we use the scanner to read the file line by line
		//we will use while loop, and loop through the entire file line by line
		//till we reach the last line
		//hasNextLine is checking for an entire line
		while(scan.hasNextLine()){
			
			//for each line we iterate
			//we store the read line into a string call newLine for re-using it again
			String newLine = scan.nextLine();
			
			//example of re-using the value again so we don't have to call scan.nextLine() again
			System.out.println(newLine);
			
		}
		
		//don't forget to close the input object which in this case
		//is the scanner we called scan, or you will create memory leak
		//if not closed
		scan.close();	
		
	}
	
}
