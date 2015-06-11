package com.xai.patterns.domain.domain;

public class Employee {

	private String name;
	private int id;
	
	public Employee(String name, int id){
		this.name = name;
		this.id = id;
	}
	
	public Employee(Employee employee){
		this.name = employee.getName();
		this.id = employee.getId();
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String toString(){
		return name + " : " + id;
	}
}
