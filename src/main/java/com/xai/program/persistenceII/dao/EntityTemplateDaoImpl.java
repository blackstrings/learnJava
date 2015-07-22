package com.xai.program.persistenceII.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.xai.program.persistenceII.model.Entity;
import com.xai.program.persistenceII.service.EntityFactory;
import com.xai.program.persistenceII.service.EntityTemplateRepoFactory;

public class EntityTemplateDaoImpl implements EntityDao {

	private Map<Integer, HashMap<String, List<String>>> monRepo;
	
	public EntityTemplateDaoImpl(){
		monRepo = EntityTemplateRepoFactory.getMonRepo();  //populate inject monRepo
	}
	
	public HashMap<String, List<String>> getById(int id){
		return monRepo.get(id);
	}
	
	public Entity getEntity(){
		return EntityFactory.getEntity(monRepo);
		
	}
	
}
