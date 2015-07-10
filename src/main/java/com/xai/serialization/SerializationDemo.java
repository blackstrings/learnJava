package com.xai.serialization;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import com.xai.patterns.domain.domain.Employee;

/**
 * Serialization is different from encoding.
 * Serialization is the process of converting an object into another form of representation
 * such as commonly a byte array or an algorithm of some sequences.
 * DeSerialization is the process of converting the data back into the object
 * it once was before it was serialized (Persistence)
 * 
 * The purpose of serialization
 * http://stackoverflow.com/questions/2232759/what-is-the-purpose-of-serialization-in-java
 * Communication - from one jvm to another jvm
 * Persistence - storing the state of an object
 * Deep copy - alternative method to avoid going through trouble making a clone method
 * Caching - if it takes 10 min to build an object, better to deserialize from a file in 10 sec
 * Cross JVM synchronization - in case another jvm has different serialization architecture
 * 
 * Hydration on the other hand, is filling in data to an existing object.
 *
 */
public class SerializationDemo {

	public static void main(String [] args){
		
		MyObject obj = new MyObject("Card", 99);
		
		//serialize object and write to file
		try{
			FileOutputStream fileOut = new FileOutputStream("res/tmp/object.ser");
			ObjectOutputStream out = new ObjectOutputStream(fileOut);
			out.writeObject(obj);
			out.close();	
			fileOut.close();
			System.out.println("Serialized complete: data is saved in res/tmp/object.ser");
		}catch(IOException i){
			i.printStackTrace();
		}
		
		
		//deserialize object
		MyObject deserializedObj = null;
		try{
			FileInputStream fileIn = new FileInputStream("res/tmp/object.ser");
			ObjectInputStream in = new ObjectInputStream(fileIn);
			deserializedObj = (MyObject) in.readObject();
			in.close();
			fileIn.close();
		}catch(IOException i){				//io issues
			i.printStackTrace();
			return;
		}catch(ClassNotFoundException c){	//in case MyObject class is not found
			System.out.println("MyObject class not found");
			c.printStackTrace();
			return;
		}
		
		System.out.println("DeSerialize complete: MyObject name: " + deserializedObj);
		
	}
	
}
