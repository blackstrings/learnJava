package com.xai.io;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

public class WriteFileOldMethodPrintWriter {

	//the method calling file and printwriter needs to handle IOException
	//in this case our main method is calling these, so we make main method handle exception
	//do this by saying "throws IOException"
	public static void main(String [] args) throws IOException {
		
		//need file object to hold path
		File file = new File("res/files/writeOldMethod.txt");
		
		//need a writer class to write to the file
		PrintWriter p = new PrintWriter(file);
		
		//tell the printer to write something
		
		//using just print
		p.print("This line will not have spaces");
		p.print("this line 2 will also");
		
		//using println
		p.println("This line is next line 1");
		p.println("this line is next line 2");
		
		//save and close the file
		p.close();
	}
	
	
	
}
