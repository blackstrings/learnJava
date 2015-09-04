package com.xai.parser.csvFiles;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.aspectj.org.eclipse.jdt.internal.compiler.flow.FinallyFlowContext;

/**
 * Comma Seperated by Value demo
 * It doesn't really read in csv, but rather a regular text base doc that
 * follows the csv structure
 * @author xlao
 *
 */
public class CsvParser {
	
	//persistent counter as one line/row will generate 2 unique ids
	public Counter counter = new Counter();
	public final static Charset ENCODING = StandardCharsets.UTF_8;
	public List<String> finalList;
	
	public String fileIn;
	public String fileOut; // = "res/files/saveOut.txt";
	
	public CsvParser(int startingIndex, String fileIn, String fileOut){
		counter.index = startingIndex;
		this.fileIn = fileIn;
		this.fileOut = fileOut;
		finalList = new ArrayList<String>();
	}
	
	public void init() throws IOException{
		
		readFile();
		writeToFile();
	}
	
	
	
	
	/*
	public static void main(String [] args) throws IOException{
		
		
		//read in file
		readFile("res/files/save.txt");
		
		//write to file
		writeToFile("res/files/saveOut.txt");
		
		
	}
	*/
	
	private void writeToFile(){
		try{
			Path path = Paths.get(fileOut);		// get file path
			
			Files.write(path, finalList, ENCODING);
			
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
	
	private void printToConsole(Counter counter, 
			String sku, 
			String hiPath, String hiXscale, String hiYscale, 
			String lowPath, String lowXscale, String lowYscale,
			String textureApp){
		
		counter.index++;
		
		StringBuilder sb1 = new StringBuilder();
		sb1.append("INSERT INTO `three_d_attributes` VALUES (");
		sb1.append(counter.index);
		sb1.append(",");
		
		sb1.append(sku);
		sb1.append(",");
		
		sb1.append("'");
		sb1.append(hiPath);
		sb1.append("',");
		
		sb1.append("'HI_RES'");
		sb1.append(",");
		
		sb1.append("'");
		sb1.append(textureApp);
		sb1.append("',");
		
		sb1.append(hiXscale);
		sb1.append(",");
		
		sb1.append(hiYscale);
		sb1.append(");");
		
		
		counter.index++;
		StringBuilder sb2 = new StringBuilder();
		sb2.append("INSERT INTO `three_d_attributes` VALUES (");
		sb2.append(counter.index);
		sb2.append(",");
		
		sb2.append(sku);
		sb2.append(",");
		
		sb2.append("'");
		sb2.append(lowPath);
		sb2.append("',");
		
		sb2.append("'LOW_RES'");
		sb2.append(",");
		
		sb2.append("'");
		sb2.append(textureApp);
		sb2.append("',");
		
		sb2.append(lowXscale);
		sb2.append(",");
		
		sb2.append(lowYscale);
		sb2.append(");");
		//id sku, path, textureFace, textureApp, xScale, yScale
		
		finalList.add(sb1.toString());
		finalList.add(sb2.toString());
		
		//too much for console to show all, so read the out file instead
		//System.out.println( sb1.toString());
		//System.out.println( sb2.toString());
		
	}
	
	private void readFile() throws IOException{
		
		Path p1 = Paths.get(fileIn);
		//Path p1 = Paths.get("res/files/testcvsdata.txt");
		
		String fileName = p1.toString();
		
		// read line by line into a list array
		List<String> lines = Files.readAllLines(p1, ENCODING);
		

		//for each line we write out two rows, one for hi and one for low res
		for(String s : lines){
			List<String> list = Arrays.asList(s.split(","));
			
			String sku = list.get(0);	//we know all data has sku filled in
			String rootPath = "NA";
			
			//hi texture path
			String hiTexture = "NA";
			
			String hiPath = "NA";
			String hiXscale = "0";
			String hiYscale = "0";
			
			//low texture path
			String lowTexture = "NA";
			String lowPath = "NA";
			String lowXscale = "0";
			String lowYscale = "0";
			
			String category = "NA";
			
			//the size must be 8 or the order will be off
			//if not 8, columns must have had blank values, so we leave n/a in place
			//basically this if prevents crashing for rows that are off or not filled in
			if(list.size() == 8){
				//sku = list.get(0);
				rootPath = list.get(1);
				
				//hi texture path
				hiTexture= list.get(2);
				
				hiPath = rootPath + hiTexture;
				hiXscale = list.get(3);
				hiYscale = list.get(4);
				
				//low texture path
				lowTexture = list.get(5);
				lowPath = rootPath + lowTexture;
				lowXscale = list.get(6);
				lowYscale = list.get(7);
				
				category = list.get(1).split("/")[0];
				
			}
			
			printToConsole(counter, 
					sku, 
					hiPath,
					hiXscale,
					hiYscale,
					lowPath,
					lowXscale,
					lowYscale,
					category.toUpperCase());
		}
	}
	
}