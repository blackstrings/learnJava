package com.xai.oopTest2;

import java.util.ArrayList;
import java.util.List;

import com.xai.oopTest2.phases.IPhase;

public class StateManager {

	private static StateManager instance;
	
	private StateManager(){}
	
	public static synchronized StateManager getInstance(){
		if(instance == null){
			instance = new StateManager();
		}
		
		return instance;
	}
	
	//-------------------------------------------------
	private IPhase currPhase;
	//-------------------------------------------------
	private User currUser;
	//-------------------------------------------------
	private List<User> users = new ArrayList<User>();
	//-------------------------------------------------
	private boolean isOver = false;
	
	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public User getCurrUser() {
		return currUser;
	}

	public void setCurrUser(User currUser) {
		this.currUser = currUser;
	}
	
	public IPhase getCurrPhase() {
		return currPhase;
	}

	public void setCurrPhase(IPhase currPhase) {
		this.currPhase = currPhase;
	}

	public boolean isOver() {
		return isOver;
	}

	public void setOver(boolean isOver) {
		this.isOver = isOver;
	}
	
}
