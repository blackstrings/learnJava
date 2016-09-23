package com.xai.serialization;

import java.io.UnsupportedEncodingException;

import org.apache.commons.codec.binary.Base64;
import org.eclipse.core.internal.filesystem.local.Convert;

public class StringSerializationDemo {

	public static void main(String [] args) throws UnsupportedEncodingException{
		
		String s1 = "Somebody";
		
		//the string must be converted to bytes
		byte[] strByte = s1.getBytes();
		
		System.out.println(strByte.toString());
		
		//base64
		byte[] b = Base64.encodeBase64(strByte);
		
		//decode bytes back to string
		String serialized = new String(Base64.decodeBase64(b));
		
		//print the output
		System.out.println(serialized);
		
	}
	
}
