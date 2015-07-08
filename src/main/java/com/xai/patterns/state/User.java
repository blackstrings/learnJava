package com.xai.patterns.state;

import java.util.ArrayList;
import java.util.List;

public class User {
	
	String name;
	List<Model> models;
	
	public String getName() {
		return name;
	}
	
	public User(String name){
		this.name = name;
		models = new ArrayList<Model>();
	}
	
	public List<Model> getModels() {
		return models;
	}
	public void setModels(List<Model> models) {
		this.models = models;
	}
	
	
}
