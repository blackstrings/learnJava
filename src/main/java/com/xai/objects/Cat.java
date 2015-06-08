package com.xai.objects;

public class Cat extends Animal implements IAnimal {
	public Cat(String name, long id){
		this.name = name;
		this.id = id;
		this.eye = new Eye(1.0);
	}
	
	public Cat(Cat cat){
		this.name = cat.getName();
		this.id = cat.getId();
		this.eye = new Eye(cat.getEyeSize());
	}
	
	public String toString(){
		return getClass().getSimpleName() + " - " + super.toString();
	}
}
