package com.xai.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ReadWriteTextFileJDK7 {
  
	  /*
	   * When you don't provide a directory, the files gets read/write from the root project folder
	   * "test.txt" will assume file is on the root
	   * 
	   * To use relative paths of the project root folder
	   *  /resources/files/text.txt --> will start going down the resource folder from the root project folder
	   *  
	   *  To use direct or absolute path starting from the C directory
	   *  "C:\\Temp\\input.txt";
	   */
	  
	  static Path inPath = Paths.get("res/files/testJDk7in.txt");
	  static Path outPath = Paths.get("res/files/testJDK7out.txt");
	  
	  
	  final static String FILE_NAME = inPath.toString(); 
	  final static String OUTPUT_FILE_NAME = outPath.toString();
	  final static Charset ENCODING = StandardCharsets.UTF_8;
	  
	  //For smaller files

	  /**
	   Note: the javadoc of Files.readAllLines says it's intended for small
	   files. But its implementation uses buffering, so it's likely good 
	   even for fairly large files.
	  */  
	
  public static void main(String... aArgs) throws IOException{
	  
    ReadWriteTextFileJDK7 io = new ReadWriteTextFileJDK7();
    
    //read the file to console
    List<String> lines = io.readSmallTextFile(FILE_NAME);	//treat as a small file
    log(lines);												// custom print method, prints entire line list in console
    
    lines.add("Item" + lines.size() ); // add new line of text to the end of the string list
    
    //## take what was read above, append additional item, and write back to file
    //io.writeSmallTextFile(lines, FILE_NAME);				// rewrite the list back to file
   
    
    //## Perform large file read/write
    io.readLargerTextFile(FILE_NAME);						//treat as a large file - use some buffering
    
    
    //## clear the testJDK7out.txt into smaller text
    //lines = Arrays.asList("someData","someWater");			// reuse lines as arrayList and set it to the new values
   
    //## read from fileA and write it to fileB
    io.writeLargerTextFile(OUTPUT_FILE_NAME, lines);   	// write the new array into file
    
  }


  public List<String> readSmallTextFile(String aFileName) throws IOException {
    Path path = Paths.get(aFileName);
    return Files.readAllLines(path, ENCODING);
  }
  
  public void writeSmallTextFile(List<String> aLines, String aFileName) throws IOException {
    Path path = Paths.get(aFileName);
    Files.write(path, aLines, ENCODING);
  }

  //For larger files
  
  public void readLargerTextFile(String aFileName) throws IOException {
    Path path = Paths.get(aFileName);
    try (Scanner scanner =  new Scanner(path, ENCODING.name())){
      while (scanner.hasNextLine()){
        //process each line in some way
        log(scanner.nextLine());
      }      
    }
  }
  
  public void readLargerTextFileAlternate(String aFileName) throws IOException {
    Path path = Paths.get(aFileName);
    try (BufferedReader reader = Files.newBufferedReader(path, ENCODING)){
      String line = null;
      while ((line = reader.readLine()) != null) {
        //process each line in some way
        log(line);
      }      
    }
  }
  
  public void writeLargerTextFile(String aFileName, List<String> aLines) throws IOException {
    Path path = Paths.get(aFileName);
    try (BufferedWriter writer = Files.newBufferedWriter(path, ENCODING)){
      for(String line : aLines){
        writer.write(line);
        writer.newLine();
      }
    }
  }

  private static void log(Object aMsg){
    System.out.println(String.valueOf(aMsg));
  }
  
} 