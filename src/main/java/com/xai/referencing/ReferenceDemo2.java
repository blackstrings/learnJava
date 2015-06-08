package com.xai.referencing;

import java.util.ArrayList;
import java.util.List;

import com.xai.objects.Cat;

public class ReferenceDemo2 {

	//inner class
	static class DogDAOImpl{
		List<Cat> dogs = new ArrayList<Cat>();
		public DogDAOImpl(){
			dogs.add(new Cat("Tom", 1L));
			dogs.add(new Cat("Kim", 2L));
		}
		public List<Cat> getDogs(){
			return dogs;
		}
	}
	
	public static void main(String[]args){
		//new dogDAO
		DogDAOImpl dogDAO = new ReferenceDemo2.DogDAOImpl();
		Cat d1 = dogDAO.getDogs().get(0);
		d1.setName("Tommy");
		
		for(Cat dog : dogDAO.getDogs()){
			System.out.println(dog.getName());
		}
	}
	
}
