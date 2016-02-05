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
 * 
 * This class is not a robust cvs parser that can take in any cvs
 * It is quite specific to a certain cvs format. Mainly it was created for parsing data
 * for garage's low and hi res image file.
 * 
 * So For each line read from the file, it will create 2 new lines
 * One line for the low res data, the 2nd one for the high res data
 * So you get two lines for every line read.
 * The reason is because one line contains similar data for the high res line
 * 
 * FYI: The hiRes x and y dpi actually don't get used and is later replaced
 * FYI: The hiRes scale are double the values we need, instead of / 2, we use the lowRes scales
 * in place
 * @author xlao
 *
 */
public class CsvSpecificParser {
	
	public enum Scale { Y, X }
	
	/**
	 * persistent counter as one line/row will generate 2 unique ids or lines
	 */
	public Counter counter = new Counter();
	
	public final static Charset ENCODING = StandardCharsets.UTF_8;
	
	//the final string that will get output or write out
	public List<String> finalList;
	
	public String fileIn;
	public String fileOut; // = "res/files/saveOut.txt";
	
	public CsvSpecificParser(int startingIndex, String fileIn, String fileOut){
		counter.index = startingIndex;
		this.fileIn = fileIn;
		this.fileOut = fileOut;
		finalList = new ArrayList<String>();
	}
	
	public void init() throws IOException{
		
		//reads in and builds the finalList string
		readFile();
		
		//writes the finalList to the output file
		writeToFile();
	}
	
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
	
	/**
	 * Again the app builds two lines for every line read in
	 * This method Builds the final two lines per call
	 * you can choose to turn on/off the print to console, default is off
	 * which is located at the end of the method
	 * 
	 * @param hiTexture although hiTexture is inside hiPath, we want to check if hiTexture was empty or not
	 * @param lowTexture although lowTexture is inside lowPath, we check if lowTexture was empty or not
	 * 
	 */
	private void buildFinalString(Counter counter, 
			String sku, 
			String hiPath, String hiXscale, String hiYscale, 
			String lowPath, String lowXscale, String lowYscale,
			String textureApp,
			String hiTexture,
			String lowTexture,
			boolean printToConsole){
		
		counter.index++;
		//System.out.println(counter.index);
		
		//build first line
		StringBuilder sb1 = new StringBuilder();
		sb1.append("INSERT INTO `three_d_attributes` VALUES (");
		sb1.append(counter.index);
		sb1.append(",");
		
		sb1.append(sku);
		sb1.append(",");
		
		sb1.append("'");
		sb1.append(hiPath);		//Roof/Asphalt/Owens-Corning/~OC_Menards_01_Berkshire/Tile1-512x512-47.19inX66.61in.jpg
		sb1.append("',");
		
		sb1.append("'HI_RES'");	//HI_RES or LOW_RES
		sb1.append(",");
		
		sb1.append("'");
		sb1.append(textureApp);	//Roof
		sb1.append("',");
		
		//due to a change, hiXscale and hiYscale will not be used anymore, but is replaced
		//instead we extract the x and y scale string from the texturePath and use those instead
		//The hiTexture was found to have double the value, so instead we use the value from low res
		//hiXscale = getScaleFromPath(hiTexture, Scale.X);	//comment this line if you want to use the original x scale dpi
		hiXscale = getScaleFromPath(lowTexture, Scale.X);
		sb1.append(hiXscale);
		sb1.append(",");
		
		//hiYscale = getScaleFromPath(hiTexture, Scale.Y);	//comment this line if you want to use the original y scale dpi
		hiYscale = getScaleFromPath(lowTexture, Scale.Y);
		sb1.append(hiYscale);
		sb1.append(");");
		
		//build 2nd line
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
		
		lowXscale = getScaleFromPath(lowTexture, Scale.X);	//comment this line if you want to use the original x scale dpi
		sb2.append(lowXscale);
		sb2.append(",");
		
		lowYscale = getScaleFromPath(lowTexture, Scale.Y);	//comment this line if you want to use the original y scale dpi
		sb2.append(lowYscale);
		sb2.append(");");

		//this is how we put everything together to create two lines from each line read in from file
		finalList.add(sb1.toString());
		finalList.add(sb2.toString());
		
		//too much for console to show all, so read the out file instead
		//keep in mind it will not print all the values so use it wisely
		//or for debugging purposes only
		if(printToConsole){
			System.out.println( sb1.toString());
			System.out.println( sb2.toString());
		}
		
	}
	
	/**
	 * Help method. the path will look something like this
	 * Tile1-512x512-29.11inX35.02in.jpg
	 * we extract the 29.11 out for X
	 * @param path
	 * @return
	 */
	private String getScaleFromPath(String texturePath, Scale scale){
		
		//lines with NA and Soffit paths are not meant to be parse for x and y scale
		if(texturePath.equals("NA") ){//|| path.startsWith("Soffit")){
			return "0.0";
		}
		
		//the actual texturePath has a chance of being empty
		//the fact we stitched texturePath inside rootPath
		if(texturePath.equals("") 
				|| texturePath.equals(" ")){
			return "0.0";	
		}
		
		//the texturePath has a chance to be incorrect, catch these
		if(texturePath.startsWith("tile_color")){
			return "0.0";
		}
		
		//ex: Tile1-512x512-29.11inX35.02in.jpg
		
		String value = "";
		if(scale == Scale.X){
			value = texturePath.split("-")[2];		//>> 29.11inX35.02in.jpg
		}else if(scale == Scale.Y){
			value = texturePath.split("X")[1];		//>> 35.02in.jpg
		}
		
		return value.split("i")[0];			//>> split at "i" so we get first index of array >> 29.11 or 35.02
	}
	
	/**
	 * Make sure that each line in the file has 8 elements, if not fill in and insert commas with a space to make 8 elements
	 * example: 343433, Roof/Tiles-23x32in/, , , , , , ,
	 * there needs to be a space between each comma or the element will not be counted in the array
	 * @throws IOException
	 */
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
			
			//set default in case they never get assign a new value
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
			
			//the size of the line must be exactly 8 elements
			//or the order will be off and thus the parse will not work
			//we are working with 8 elements here
			//if not 8, columns must have had blank values, so we leave n/a in place
			//basically this if prevents crashing for rows that are off or not filled in
			
			/* each line has 8 parts, thus we split them out into 8 sections
			1512801,												//0	= sku
			Roof/Asphalt/Owens-Corning/~OC_Menards_02_Classic/,		//1	= root path
			Tile0-512x512-95.24inX59.81in.jpg,						//2 = hi-res texture path
			64.512,													//3	= x-hi-res dpi
			102.726,												//4	= y-hi-res dpi
			Tile0-256x256-47.62inX29.90in.jpg,						//5 = low-res texture path
			32.256,													//6 = x-low-res dpi
			51.363													//7 = y-low-res dpi
			*/
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
				
			}else if(list.size() > 8){
				throw new IOException("element greater than 8");
			}else if(list.size() < 8){
				System.out.println(list.toString());
				throw new IOException("element less than 8");	//remove when done testing
			}
			
			buildFinalString(counter, 
					sku, 
					hiPath,
					hiXscale,
					hiYscale,
					lowPath,
					lowXscale,
					lowYscale,
					category.toUpperCase(),
					hiTexture,
					lowTexture,
					false);
		}
	}
	
}