package com.xai.images;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;

/**
 * This program will perform a image batch conversion
 * Through each iteration, the program will convert an image from typeA into typeB. (Example: from PNG to JPEG).
 * After the type conversion, it will save the new image file to a different directory.
 * @author xlao
 *
 */
public class BatchImageConverter {

	//default
	public BatchImageConverter(){}
	
	//mod construct
	public BatchImageConverter(String fromDirectory, String toDirectory, ConvertTo extension){
		init(fromDirectory, toDirectory, extension);
	}
	
	/**
	 * Gather and store all image paths from directoryA
	 */
	private List<String> fileNames;

	private String fromDirectoryPath;
	private String toDirectoryPath;
	private ConvertTo extension;

	public enum ConvertTo {
		PNG("png"), 
		JPEG("jpg");
		
		public String val;
		ConvertTo(String val){
			this.val = val;
		}
	}

	public void init(String fromDirectoryPath, String toDirectoryPath, ConvertTo extension) {

		if(!fromDirectoryPath.isEmpty() && !toDirectoryPath.isEmpty() ){
			this.extension = extension;
			fileNames = new ArrayList<String>();

			//gather all files fromDirectoryPath
			File folder = new File(fromDirectoryPath);
			File[] listOfFiles = folder.listFiles();

			//validate everything pass first
			if( validateFiles(listOfFiles, extension) ){
				
				//perform conversion to each file
				for(File fileName : listOfFiles){
					convertImage(fileName.getName(), fromDirectoryPath, toDirectoryPath, extension);
				}

				//me trying to do stuff - no longer needed
				//get the fileNames out from the list
				/*
					for (int i = 0; i < listOfFiles.length; i++) {
						if (listOfFiles[i].isFile()) {

							//store the name
							fileNames.add(listOfFiles[i].getName());
							//System.out.println("File " + listOfFiles[i].getName());
						} else if (listOfFiles[i].isDirectory()) {
							//System.out.println("Directory " + listOfFiles[i].getName());
						}
					}
				 */
				
			}

		}

	}
	
	private void convertImage(String fileName, String fromDirectory, String toDirectory, ConvertTo extension){
		
		BufferedImage bufferedImage;
		
		try {
 
			//System.out.println(System.getProperty("user.dir"));
			
			//read image file
			bufferedImage = ImageIO.read(new File(fromDirectory + "/" + fileName));

			// create a blank, RGB, same width and height, and a white background
			BufferedImage newBufferedImage = new BufferedImage(bufferedImage.getWidth(),
					bufferedImage.getHeight(), BufferedImage.TYPE_INT_RGB);
			
			newBufferedImage.createGraphics().drawImage(bufferedImage, 0, 0, Color.WHITE, null);

			String fileNameNoExtension = fileName.split("\\.")[0]; 		//returns fileName from filenName.ext
			
			// write to jpeg file
			ImageIO.write(newBufferedImage, 
					extension.val, new File(toDirectory + "/" + fileNameNoExtension + "." + extension.val));

			System.out.println("Done");
 
		} catch (IOException e) {

			e.printStackTrace();

		}
	}
	
	private boolean validateFiles(File[] file, ConvertTo extension){
		
		if(file != null){
			
			//validate there are files to be converted
			if(file.length == 0){
				try { throw new Exception("FromDirectory is an empty folder."); } catch (Exception e) { e.printStackTrace(); }
				return false;
			}
			
			//validate we are not converting to the same file type
			String currentFileExtension = file[0].getName().split("\\.")[1]; //fileName.png >> fileName
			if(currentFileExtension.equals(extension.val)){
				try { throw new Exception("Cannot convert from [" +  currentFileExtension + "] to [" + extension.val + 
										"], convert to a different type");
				} catch (Exception e) { e.printStackTrace(); }
				return false;
			}
			
			//validation pass
			return true;
			
		}else{	
			
			//files is null
			try { throw new FileNotFoundException("Check the fromDirectory path."); } catch (Exception e) { e.printStackTrace();}
			return false;
		}
	}



}