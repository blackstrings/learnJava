package com.xai.parser.csvReader;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.opencsv.CSVReader;

public class CsvReaderDemo {

	public static void main(String [] args) {
		
	try(CSVReader reader = new CSVReader(new BufferedReader(
			new FileReader("res/files/save.txt")))){
		
		 List<String[]> lines = reader.readAll();
		 
		 List<String> keys = new ArrayList<String>();
		 
		 
		 int sku = 0;
		 int root = 1;
		 int hiRes = 2;
		 int hiResX = 3;
		 int hiResY = 4;
		 int lowRes = 5;
		 int lowResX = 6;
		 int lowResY = 7;
		 
		 
		 for(String[] line : lines){
			 
			 System.out.println(line[root]);
			
			 StringBuilder sb = new StringBuilder();
			 sb.append("INSERT INTO VALUES");
			 sb.append(line[sku]);
		 }
		 
		 //String[][] list = lines.toArray(new String[lines.size()][]);
		 int num = 0;
				
	} catch (FileNotFoundException e) {
		e.printStackTrace();
	} catch (IOException e) {
		e.printStackTrace();
	}
	
			
	}
	
}
