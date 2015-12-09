package com.xai.gui.jframe.shopping;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Random;
import java.util.Scanner;

/**
 *  Think of this class as being the store walmart.
 *  It holds all the possible items any customer can buy.
 * @author xlao
 *
 */

public class Store {

	//this class handles the catalog array that will be holding all the possible items
	//a customer can buy
	
	CatalogItem[] catalogArray;
	
	//keeps track of the current size, since this is an parital array
	//increment this variable when loading items into the catalogArray
	int maxSize = 0;
	
	public Store(){
		System.out.println("Store created");
	}
	
	/**
	 * read the file and load all items from file into catalog array
	 * @throws FileNotFoundException 
	 */
	public void loadItems(String textFilePath) throws FileNotFoundException{
		//prepare the array, give it a partial size of 50, we hope items from file will
		//not exceed 50 for now, if you know it will exceed 50, then increase to 100
		//and repeat increasing this number until you know how many 
		//items total will be loaded from the actual file
		catalogArray = new CatalogItem[50];

		//read from file and load items into catalogArray
		//catalogArray = readFromFile(data);	//pseudo code
		File fileIn = new File(textFilePath);	//create the file object by passing in the file path
		Scanner scan = new Scanner(fileIn);		//pass in the file to scanner
		
		//now we use the scanner to read the file line by line
		//we will use while loop, and loop through the entire file line by line
		//till we reach the last line
		//hasNextLine is checking for an entire line
		int counter = 0;
		while(scan.hasNextLine()){
			
			//for each line we iterate
			//we store the read line into a string call newLine for re-using it again
			String newLine = scan.nextLine();
			String[] item = newLine.split(",");
			
			//when we use the string split, it will split data by comma
			//ex: if the data text file's first line is
			//C32352,Jordan Shoe,83.99,res/images/someshoe.jpg
			//we can tell that index 0 holds catNum and index 1 holds the description
			String itemCatNum = item[0];
			String itemDesc = item[1];
			String itemPrice = item[2];
			String itemImagePath = item[3];
			
			//we create the catalogItem and assign it into the catalog array
			catalogArray[counter] = 
					new CatalogItem(itemCatNum, itemDesc, Double.parseDouble(itemPrice), itemImagePath);
			
			counter++;
		}
		
		//once the loop is done, we know counter has been keeping track of each item
		//so we pass the value of counter to the global maxSize
		//also maxSize is a better name to indicate the store has X amount of items
		maxSize = counter;	
		
		//don't forget to close the input object which in this case
		//is the scanner we called scan, or you will create memory leak
		//if not closed
		scan.close();	
		
		// test data for now, until we implement loading items from an actual file
		//basically the cheap version to get started instead of loading from an actual file
		//it populates the catalogArray with test items using a for loop method
		/*
		for(int i=0; i<10; i++){
			Random rand = new Random();
			char clothingChar;
			if(rand.nextBoolean()){
				clothingChar = 'C';
			}else{
				clothingChar = 'D';
			}
			catalogArray[i] = new CatalogItem(clothingChar + "100"+i, 
					"item descripotion super long long description and super super long "+i, 
					1.99+i, 
					"res/images/icon"+i+".png");
			maxSize++;
		}
		*/
		
	}
	
	
	
}
