package com.xai.patterns.state;

import java.util.List;

import com.xai.patterns.state.phase.IPhase;

public class Service {
	
	public static void init(){
		getStateManager();
	}
	
	
	public static int getOutFromUser(User user){
		List<Model> models = user.getModels();
		
		if(models != null && models.size() > 0){
			int out = 0;
			
			for(Model model : models){
				out += getOutFromModel(model);
			}
			return out;
		}
		return 0;
	}
	
	private static int getOutFromModel(Model model){
		int out = 0;
		for(Wep wep : model.getWeps()){
			out += wep.getOut();
		}
		return out;
	}
	
	public static void addModelToUser(Model model, User user){
		user.getModels().add(model);
	}
	
	public static void addWepToModel(Wep wep, Model model){
		List<Wep> weps = model.getWeps();
		if(weps != null){
			weps.add(wep);
		}
	}
	
	public static void addUser(String username){
		getStateManager().getUsers().add(new User(username));
	}
	
	public static List<User> getUsers(){
		return getStateManager().getUsers();
	}
	
	public static StateManager getStateManager(){
		return StateManager.getInstance();
	}
	
	public static void setPhase(IPhase phase){
		getStateManager().setCurrPhase(phase);
	}
	
	public static IPhase getPhase(){
		return getStateManager().getCurrPhase();
	}
	
	public static boolean isOver(){
		return getStateManager().isOver();
	}
	
	public static void reset(){
		getStateManager().reset();
	}
	
}
