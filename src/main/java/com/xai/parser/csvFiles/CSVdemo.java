package com.xai.parser.csvFiles;

import java.io.IOException;

public class CSVdemo {

	/**
	 * This usage here is a little special. For each line, it will make 2 new lines.
	 * One line for the low res data, the 2nd one for the high res data
	 * @param args
	 * @throws IOException
	 */
	public static void main(String [] args) throws IOException{
		
		CsvParser parser = new CsvParser(2804, "res/files/save.txt", "res/files/saveOut.txt");
		parser.init();
	}
}
