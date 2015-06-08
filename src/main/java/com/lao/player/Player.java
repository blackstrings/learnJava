package com.lao.player;

public class Player {
	private String name;
	private Integer age;
	private Double statusModifier;

	public Player(String name, Integer age, Double statusModifier){
		this.name=name;
		this.age=age;
		this.statusModifier=statusModifier;
	}

	public String toString() {
		return "Player [name=" + name + ", age=" + age + ", statusModifier="
				+ statusModifier + "]";
	}

	//overriding the hascode gives you ability to modify more unique hashcode and compare
	// each field later in when collision occurs during hashing 
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((age == null) ? 0 : age.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result
				+ ((statusModifier == null) ? 0 : statusModifier.hashCode());
		return result;
	}

	//when overriding your own equals, you have to implement the hashcode above
	public boolean equals(Object obj) {
		//first check if this equal obj
		if (this == obj)
			return true;
		//then check if obj is null
		if (obj == null)
			return false;
		//then check by class
		if (getClass() != obj.getClass())
			return false;
		//convert obj to class
		Player other = (Player) obj;
		if (age == null) {
			if (other.age != null)
				return false;
		} else if (!age.equals(other.age))
			return false;
		
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (statusModifier == null) {
			if (other.statusModifier != null)
				return false;
		} else if (!statusModifier.equals(other.statusModifier))
			return false;
		
		//must be true if all the false were not trigger
		return true;
	}

	public String getName() {return name;}
	public void setName(String name) {this.name = name;}
	public Integer getAge() {return age;}
	public void setAge(Integer age) {this.age = age;}
	public Double getStatusModifier() {return statusModifier;}
	public void setStatusModifier(Double statusModifier) {this.statusModifier = statusModifier;}
}
