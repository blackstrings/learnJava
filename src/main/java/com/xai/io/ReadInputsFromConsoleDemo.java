package com.xai.io;

import java.io.IOException;
import java.io.InputStreamReader;

public class ReadInputsFromConsoleDemo {
   public static void main(String args[]) throws IOException{
      InputStreamReader cin = null;

      try {

    	  //program will pause for input in the console
    	  cin = new InputStreamReader(System.in);
    	  System.out.println("Enter characters, 'q' to quit.");
    	  
    	  char c;
    	  do {
    		  c = (char) cin.read();	//read each character from the console line one by one
    		  System.out.print(c);		//print each character from console line one by one
    	  } while(c != '~');			//as long as this symbol is not present, keep printing
    	  
      }finally{
    	  
    	  //close the stream when the program has quit
    	  if (cin != null) {
    		  cin.close();
    	  }
    	  
      }
   }
}