package com.xai.format;

import java.io.PrintWriter;
import java.util.Formatter;

public class StringDemo {

	public static void main(String [] args){
		
		//genereate string array
		String[] strArr = new String[15];
		
		for(int i=0; i<11; i++){
			strArr[i] = "str" + i;
		}
		
		for(String str : strArr){
			System.out.println(str);
		}
		
		//the formatter helps with building strings in a way
		Formatter f = new Formatter();
		f.format("%s", strArr[0]);
		
		System.out.println(f);
		
	}
}
