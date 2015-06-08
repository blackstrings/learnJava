package com.xai.io;

/**
 * Java provides several ways to write a file, we can use FileWriter, BufferedWriter, 
 * java 7 Files and FileOutputStream to write file in Java.
 * FileWriter: FileWriter is the simplest way to write a file in java, 
 * it provides overloaded write method to write int, byte array and String to the File. 
 * You can also write part of the String or byte array using FileWriter. 
 * FileWriter writes directly into Files and should be used only when number of writes are less.

BufferedWriter: BufferedWriter is almost similar to FileWriter but it uses internal 
buffer to write data into File. So if the number of write operations are more, 
the actual IO operations are less and performance is better. You should use BufferedWriter 
when number of write operations are more.

FileOutputStream: FileWriter and BufferedWriter are meant to write text to the 
file but when you need raw stream data to be written into file, you should use 
FileOutputStream to write file in java.

Files: Java 7 introduced Files utility class and we can write a file using it’s 
write function, internally it’s using OutputStream to write byte array into file.
 * 
 *
 */

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

public class JDK7WriteDemo {

	private static String fileIn = "res/files/saveCache.txt";
	
    /**
     * This class shows how to write file in java
     * @param args
     * @throws IOException 
     */
    public static void main(String[] args) {
        String data1 = "I will write this String to File in Java using FileWriter";
        String data2 = "I will write this String to File in Java using BufferWriter";
        String data3 = "I will write this String to File in Java using Files";
        String data4 = "I will write this String to File in Java using OutputStream";
        int noOfLines = 10000;
        
//        writeUsingFileWriter(data1);		// old way not working much
         
//        writeUsingBufferedWriter(data2, noOfLines);		// old way not working much
         
        writeUsingFiles(data3);
         
//        writeUsingOutputStream(data4);
        
        System.out.println("DONE");
    }
 
    /**
     * Use Streams when you are dealing with raw data
     * @param data
     */
    private static void writeUsingOutputStream(String data) {
        OutputStream os = null;
        try {
            os = new FileOutputStream(new File(fileIn));
            os.write(data.getBytes(), 0, data.length());
        } catch (IOException e) {
            e.printStackTrace();
        }finally{
            try {
                os.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
     
    /**
     * Use Files class from Java 1.7 to write files, internally uses OutputStream
     * @param data
     */
    private static void writeUsingFiles(String data) {
        try {
        	Files.write(Paths.get(fileIn), data.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
 
    /**
     * Use BufferedWriter when number of write operations are more
     * It uses internal buffer to reduce real IO operations and saves time
     * @param data
     * @param noOfLines
     */
    private static void writeUsingBufferedWriter(String data, int noOfLines) {
        File file = new File("fileIn");
        FileWriter fr = null;
        BufferedWriter br = null;
        String dataWithNewLine=data+System.getProperty("line.separator");
        try{
            fr = new FileWriter(file);
            br = new BufferedWriter(fr);
            for(int i = noOfLines; i>0; i--){
                br.write(dataWithNewLine);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally{
            try {
                br.close();
                fr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
 
    /**
     * Use FileWriter when number of write operations are less
     * @param data
     */
    private static void writeUsingFileWriter(String data) {
        File file = new File("fileIn");
        FileWriter fr = null;
        try {
            fr = new FileWriter(file);
            fr.write(data);
        } catch (IOException e) {
            e.printStackTrace();
        }finally{
            //close resources
            try {
                fr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
	 
}
