package com.xai.program.travel;

public abstract class TravelEvent {

	protected User user;
	public TravelEvent(User user){
		this.user = user;
	}
	public abstract void action();
	
	protected void clearEvent(){
		user = null;
	}
}
