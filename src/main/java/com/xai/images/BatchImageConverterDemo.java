package com.xai.images;

import com.xai.images.BatchImageConverter.ConvertTo;

public class BatchImageConverterDemo {

	public static void main(String [] args){

		BatchImageConverter bic = new BatchImageConverter();
		
		String fromDirectory = "res/images/raw";	
		String toDirectory = "res/images";

		bic.init(fromDirectory, toDirectory, ConvertTo.JPEG);

		//or all in one line
		//new BatchImageConverter(fromDirectory, toDirectory, ConvertTo.JPEG);
		
	}
	
}
