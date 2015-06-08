package com.xai.exceptions;

import java.util.ArrayList;
import java.util.List;

public class InvalidNameException extends Exception {
	
	private String name;
	private List<String> names = new ArrayList<String>(){{
		add("No");
		add("Yes");
	
	}};
	
	
	public InvalidNameException(String name){
		this.name = name;
	}
	
	public String toString(){
		String str = super.toString();
		return str + " : " + "the name \"" + this.name + "\" cannot be used";
	}
	
}
