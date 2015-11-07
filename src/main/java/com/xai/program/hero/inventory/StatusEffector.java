package com.xai.program.hero.inventory;

public class StatusEffector implements IEffector {

	StatusType type;
	
	public StatusEffector(StatusType type){
		this.type = type;
	}
	
	@Override
	public void applyEffect(Object target) {

		//Status effect
		if(target instanceof IStatusable){
			IStatusable obj = (IStatusable) target;
			obj.applyStatus(type);
		}
		
	}

}
