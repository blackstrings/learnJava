package com.xai.abstraction.controller.demo;

import java.util.ArrayList;
import java.util.List;

public class PlayerAnimController extends ControllerBase {

	List<PlayerBehavior> pbs = new ArrayList<PlayerBehavior>();
	
	public void addBehavior(PlayerBehavior pb){
		pbs.add(pb);
	}
	//
	public void run(){
		for(PlayerBehavior pb : pbs){
			if(pb instanceof Run){
				pb.action();
				break;
			}
		}
	}
}
