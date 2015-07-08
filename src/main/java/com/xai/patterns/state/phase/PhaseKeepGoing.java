package com.xai.patterns.state.phase;

import java.util.Random;

import com.xai.patterns.state.Model;
import com.xai.patterns.state.Phase;
import com.xai.patterns.state.Service;
import com.xai.patterns.state.User;
import com.xai.patterns.state.Wep;

public class PhaseKeepGoing implements IPhase{

	public PhaseKeepGoing(){
		
	}
	
	@Override
	public void execute(){
		System.out.println("PhaseKeepGoing");
		
		int index = 0;
		
		//per user gets an object of some sort
		for(User user : Service.getUsers()){
			int rand = new Random().nextInt(10);
			Wep wep = new Wep(rand);
			Model model = new Model("BaseModel" + index);
			Service.addWepToModel(wep, model);
			Service.addModelToUser(model, user);
			index++;
			
			System.out.println(user.getName() + " out : " + Service.getOutFromUser(user));
		}
		
		setNextPhase(new PhaseOver());
	}

	@Override
	public void setNextPhase(IPhase phase) {
		Service.setPhase(phase);
	}
}
