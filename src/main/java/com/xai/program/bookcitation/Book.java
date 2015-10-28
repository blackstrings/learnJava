package com.xai.program.bookcitation;

public class Book {
	
	public String title;
	public String desc;
	public int year;
	
	public Book(String title, String desc, int year){
		this.title = title;
		this.desc = desc;
		this.year = year;
	}
	
	public String apaStyle(){
		
		String finalString = title + ", " + desc + ", " + year;
		return finalString;
	}
	
	
}
