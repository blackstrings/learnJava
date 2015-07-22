package com.xai.program.persistenceII;

import com.xai.program.persistenceII.dao.EntityTemplateDaoImpl;
import com.xai.program.persistenceII.model.Entity;
import com.xai.program.persistenceII.service.PersistentState;
import com.xai.program.persistenceII.service.SaveLoad;

public class PersistenceDemoII {

	public static void main(String [] args){
		
		//populateMoreMon();	//start from fresh data with no load
		loadTest();
		populateMoreMon();
		
		//save
		SaveLoad.save();
	}
	
	private static void loadTest(){
		PersistentState state = PersistentState.getInstance();
		EntityTemplateDaoImpl entityDao = new EntityTemplateDaoImpl();
		SaveLoad.load();
	}
	
	private static void populateMoreMon(){
		PersistentState state = PersistentState.getInstance();
		EntityTemplateDaoImpl entityDao = new EntityTemplateDaoImpl();
		
		//get entity
		Entity entity = entityDao.getEntity();
		state.addMon(entity);
		entity = entityDao.getEntity();
		state.addMon(entity);
	}
	
}
