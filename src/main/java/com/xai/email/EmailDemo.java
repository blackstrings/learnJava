package com.xai.email;

import java.util.HashMap;
import java.util.Map;

public class EmailDemo {

	public static void main(String[] args){
		
		MyEmail email = new MyEmail();
		
		String url = "http://www.xailao.com";
		Map<String, String> parameters = new HashMap<String, String>();
		parameters.put("appName", "JavaTestApp");
		parameters.put("info", "This is some test info");
		
		email.send(url, parameters);
		
	}
}
