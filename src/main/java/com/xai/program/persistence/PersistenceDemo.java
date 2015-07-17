package com.xai.program.persistence;

import java.util.HashMap;
import java.util.List;

public class PersistenceDemo {

	public static void main(String [] args){
		
		//populate repo with basic json object
		PersistenceRepositoryBasic basic = new PersistenceRepositoryBasic();
		
		//populate repo with more advance object that has array
		PersistenceRespositoryAdvance advance = new PersistenceRespositoryAdvance();

		
		//get item from repo
		HashMap<String, List<String>> mon = advance.getMonster(9005);
		
	}
}
