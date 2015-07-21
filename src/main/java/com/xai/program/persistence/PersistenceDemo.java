package com.xai.program.persistence;

import java.util.HashMap;
import java.util.List;

//reading from presistence repo
public class PersistenceDemo {

	public static void main(String [] args){
		
		//populate repo with basic json object
		PersistenceRepositoryBasic repoBasic = new PersistenceRepositoryBasic();
		
		//populate repo with more advance object that has array
		PersistenceRespositoryAdvance repoAdvance = new PersistenceRespositoryAdvance();

		
		//get item from repo
		HashMap<String, List<String>> mon = repoAdvance.getMonster(9005);
		HashMap<String, List<String>> wep = repoAdvance.getWeapon(1002);
		
	}
}
