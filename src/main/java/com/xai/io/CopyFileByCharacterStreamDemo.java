package com.xai.io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * The old way of file input and output - copies data in fileA to fileB
 * This is a slow way because it opens the out file and writes to it per character
 * A better approach would be to build the string first, then just write the string to the file once
 * @author xlao
 *
 */
public class CopyFileByCharacterStreamDemo {

	public static void main (String [] args) throws IOException{
		
		String fileIn = "res/files/test.txt";
		String fileOut = "res/files/test3.txt";
		
		FileInputStream in = null;
		FileOutputStream out = null;	
		try{
			in = new FileInputStream(fileIn);
			out = new FileOutputStream(fileOut);
			
			int c;
			
			while ( (c = in.read()) != -1){
				out.write(c);
			}
		}finally{
			if(in != null) {
				in.close();
			}
			if(out != null){
				out.close();
			}
			System.out.println("Copying complete");
		}
		
	}
	
}
