package com.xai.objects;

public abstract class Animal {
	protected String name;
	protected long id;
	protected Eye eye;
	
	public String getName(){
		return name;
	}
	public void setId(long id){
		this.id = id;
	}
	public long getId(){
		return id;
	}
	
	public void setName(String name){
		this.name = name;
	}
	
	public Eye getEye(){
		return eye;
	}
	public double getEyeSize(){
		return eye.getSize();
	}
	public void setEyeSize(double size){
		eye.setSize(size);
	}
	
	public String toString(){
		return "Name: " + name + ", EyeSize: " + eye.getSize();
	}
}
