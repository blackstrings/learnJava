package com.xai.io;

import java.io.File;

public class CreateDirectory {

	public static void main(String args[]) {
	      String dirname = "/tmp/user/java/test";
	      File d = new File(dirname);
	      // Create directory now.
	      d.mkdirs();
	  }
	
}
