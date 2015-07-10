package com.xai.encryption;

import javax.xml.bind.DatatypeConverter;

/**
 * <p>
 * Encryption is not serialization. Encryption is like cryptography.
 * Encryption is all for the purpose of tightening security.
 * It is the process of taking information of some kind
 * (which can represent a name, phrase, password, username, login, etc)
 * whether it be in the form of a string, integer, object, etc
 * and turning this info into something as hard as possible for human to read
 * Once encrypted, decryption cannot happen without the proper permission or authentication.
 * </p>
 *
 *<p>
 *The deeper the encryption is, the harder it becomes to decipher the encoded information using software tools.
 *</p>
 */
public class EncryptionDemo {

	//sample of a very easy encryption for strings
	//we use base64 encryption for strings
	public static void main(String [] args){
		
		//encrypt
		String strToEncrypt = "Information that is very secret";
		String encryptedStr = encrypt(strToEncrypt);
		System.out.println("encrypted string : " + encryptedStr);
		
		//decrypt
		String decryptedString = decrypt(encryptedStr);
		System.out.println("decrypted string : " + decryptedString);
	}
	
	/**
	 * Encrypt
	 * @param str
	 * @return
	 */
	private static String encrypt(String str){
		//convert to bytes
		byte[] byteArray = str.getBytes();
		
		
		//For text, don't just print byteArray into in a string
		//it is best to use the base64 method otherwise you'll get
		//i.e. 32325235353323 which you have no way of knowing 
		//if 323 or 32 should be combine to make up the first or 2nd character
		String base64StringEncrypted = DatatypeConverter.printBase64Binary(byteArray);
		
		return base64StringEncrypted;
	}

	/**
	 * Decrypt
	 * @param str
	 * @return
	 */
	private static String decrypt(String str){
		
		//convert encrypted string back to byte using the same encryption tool to decrypt
		byte[] base64Decoded = DatatypeConverter.parseBase64Binary(str);
		
		//convert byte back to string
		String decryptedString = new String(base64Decoded);
		
		return decryptedString;
	}
	
}
