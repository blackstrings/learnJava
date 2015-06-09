package com.xai.oopTest2;

import java.util.ArrayList;
import java.util.List;

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
	private Phase currPhase;
	//-------------------------------------------------
	private User currUser;
	//-------------------------------------------------
	private List<User> users = new ArrayList<User>();
	//-------------------------------------------------
	
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
	
	public Phase getCurrPhase() {
		return currPhase;
	}

	public void setCurrPhase(Phase currPhase) {
		this.currPhase = currPhase;
	}
	
}
