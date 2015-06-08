package com.xai.dataStructure;

/**
 * This is an immutable class. Immutable classes are good for key objects inside
 * hashmap because they cannot change state once they are created
 * all fields should be private
 * @author xlao
 *
 */
public class Person {
	
	private Integer id;
	private String name;
	
	public Person(Integer id){
		this.id = id;
	}
	
	public String getName(){
		return name;
	}
	public void setName(String name){
		this.name = name;
	}
	
	public int getId(){
		return id;
	}
	
	//depends only on id
	@Override
	public int hashCode(){
		//31 is an odd prime number and is also a tradition practice
		//31 also gives a good distribution in generating the hashcode
		//even numbers will cause shifting which is not good
		final int prime = 31;	
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}
	
	//compare to person ids
	@Override
	public boolean equals(Object obj){
		//the basic check
		//-------------------------------
		if(this == obj)
			return true;
		
		if(obj == null)
			return false;
		
		if(getClass() != obj.getClass())
			return false;
		//--------------------------------
		//end of basic check
		
		//convert the obj over if code reaches this point
		//and compare the objects to their deeper values
		Person other = (Person) obj;
		
		//compare id
		if(id == null){
			if(other.id != null)
				return false;
		}else if(!id.equals(other.id)){
			return false;
		}
		
		//compare name
		if(name == null){
			if(other.name != null)
				return false;
		}else if(!name.equals(other.name))
			return false;
			
		//by this point we can certainly assume the obj are equal
		return true;
	}
	
}
