package com.xai.ddd.domain;

public enum Country {
	USA("us"), THAILAND("baht"), EUROPE("euro"), CHINESE("yuan");
	
	private String type;
	private Country(String type){
		this.type = type;
	}
	
	public String getType(){
		return type;
	}
}
