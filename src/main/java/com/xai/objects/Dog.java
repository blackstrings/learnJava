package com.xai.objects;

public class Dog extends Animal implements IAnimal {
	public Dog(String name, long id){
		this.name = name;
		this.id = id;
		this.eye = new Eye(1.0);
	}
	
	public Dog(Dog dog){
		this.name = dog.getName();
		this.id = dog.getId();
		this.eye = new Eye(dog.getEyeSize());
	}
	
	public String toString(){
		return getClass().getSimpleName() + " - " + super.toString();
	}
}
