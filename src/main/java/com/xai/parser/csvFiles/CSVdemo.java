package com.xai.parser.csvFiles;

import java.io.IOException;

public class CSVdemo {

	
	public static void main(String [] args) throws IOException{
		
		CsvParser parser = new CsvParser(2804, "res/files/save.txt", "res/files/saveOut.txt");
		parser.init();
	}
}
