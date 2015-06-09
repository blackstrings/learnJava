package com.xai.oopTest2.phases;

import java.util.Random;

import com.xai.oopTest2.Model;
import com.xai.oopTest2.Phase;
import com.xai.oopTest2.Service;
import com.xai.oopTest2.User;
import com.xai.oopTest2.Wep;

public class PhaseKeepGoing implements IPhase{

	public PhaseKeepGoing(){
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
		
		setNextPhase(Phase.OVER);
	}

	@Override
	public void setNextPhase(Phase phase) {
		Service.setPhase(phase);
	}
}
