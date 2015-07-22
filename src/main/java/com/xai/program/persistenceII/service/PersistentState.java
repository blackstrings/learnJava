package com.xai.program.persistenceII.service;

import java.util.ArrayList;
import java.util.List;

import com.xai.program.persistenceII.dao.EntityTemplateDaoImpl;
import com.xai.program.persistenceII.model.Entity;
import com.xai.program.persistenceII.model.GameObject.Prop;

//singleton
public class PersistentState {
	
	private static PersistentState instance;
	
	private PersistentState(){
		mons = new ArrayList<Entity>();
	}
	
	public static synchronized PersistentState getInstance(){
		if(instance == null){
			instance = new PersistentState();
		}
		
		return instance;
	}
	
	//-----------------------------------------------------
	
	
	private List<Entity> mons;

	public List<Entity> getMons() {
		return mons;
	}

	public void setMons(List<Entity> mons) {
		this.mons = mons;
	}
	
	public void addMon(Entity mon){
		mons.add(mon);
	}
	public Entity getMon(int id){
		for(Entity mon : mons){
			if(mon.getProp(Prop.ID).equals(id)){
				return mon;
			}
		}
		return null;
	}
	
}
