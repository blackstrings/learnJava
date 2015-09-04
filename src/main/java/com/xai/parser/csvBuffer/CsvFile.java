package com.xai.parser.csvBuffer;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


public class CsvFile {

	private String splitBy;
	private String fileInPath;
	
	private BufferedReader br;
	private String line;
	private Map<String, String> map;
	
	
	public CsvFile(String splitBy, String fileInPath){
		this.splitBy = splitBy;
		this.fileInPath = fileInPath;
		
		map = new HashMap<String, String>();
		line = "";
	}
	
	public void init(){
		
		try {
			br = new BufferedReader( new FileReader(fileInPath));
		
			while( (line = br.readLine()) != null){
				String[] data = line.split(splitBy);
				
				System.out.println(data[0]);
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
