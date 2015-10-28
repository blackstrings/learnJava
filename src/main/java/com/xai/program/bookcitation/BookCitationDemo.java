package com.xai.program.bookcitation;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

public class BookCitationDemo {

	
	public static void main(String[] args) throws IOException{
		
		
		
		System.out.println();
		
		Book book = new Book("The King", "About the little son", 1999);
		
		Book[] books = new Book[15];	
		
		for(int i=0; i<10; i++){
			books[i] = new Book("The " + i, "About " + i, 2000+i);
		}
		
		int counter = 0;
		for(Book book1 : books){
			if(counter < 10){
				System.out.println(book1.apaStyle());
			}
			counter++;
		}
	}
}
