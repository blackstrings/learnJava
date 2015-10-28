package com.xai.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;


public class ReadFileOldMethodCharByChar {

	//when reading file you must handle IO exceptions
	//If a file is not found, the JVM will throw an IO exception type
	//therefore because this main method is going to be handling reading in a file
	//we will make main method handle the exception by saying
	//throws FileNotFoundException
	public static void main(String [] args) throws IOException{
		
		String fileIn = "res/files/test.txt";
		
		File f = new File(fileIn);
		InputStream ins = new FileInputStream(f);
		
		int size = ins.available();
		
		for(int i=0; i<size; i++){
			System.out.print((char)ins.read());
		}
		ins.close();
		
	}
}
