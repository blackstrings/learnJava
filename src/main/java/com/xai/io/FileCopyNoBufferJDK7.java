package com.xai.io;

import java.io.*;

/**
 * This example copies data in FileA.txt to FileB.txt overwriting everything in FileB with FileA data.
 * @author xlao
 *
 */
public class FileCopyNoBufferJDK7 {
	
	   public static void main(String[] args) throws IOException{
	      String inFileStr = "res/files/test.txt";
	      String outFileStr = "res/files/test3.txt";
	      long startTime, elapsedTime;  // for speed benchmarking
	 
	      // Check file length
	      File fileIn = new File(inFileStr);
	      System.out.println("File size is " + fileIn.length() + " bytes");
	 
	      // "try-with-resources" automatically closes all opened resources.
	      try (FileInputStream  in  = new FileInputStream(inFileStr);
	           FileOutputStream out = new FileOutputStream(outFileStr)) {
	 
	         startTime = System.nanoTime();
	         int byteRead;
	         // Read a raw byte, returns an int of 0 to 255.
	         while ((byteRead = in.read()) != -1) {
	            // Write the least-significant byte of int, drop the upper 3 bytes
	            out.write(byteRead);
	         }
	         elapsedTime = System.nanoTime() - startTime;
	         System.out.println("Elapsed Time is " + (elapsedTime / 1000000.0) + " msec");
	      } catch (IOException ex) {
	         ex.printStackTrace();
	      }
	   }
	}
