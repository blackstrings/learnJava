package com.xai.oopTest2.phases;

import java.util.Random;

import com.xai.oopTest2.Model;
import com.xai.oopTest2.Phase;
import com.xai.oopTest2.Service;
import com.xai.oopTest2.User;
import com.xai.oopTest2.Wep;

public class PhaseKeepGoing implements IPhase{

	public PhaseKeepGoing(){
		
	}
	
	@Override
	public void execute(){
		System.out.println("PhaseKeepGoing");
		
		int index = 0;
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
