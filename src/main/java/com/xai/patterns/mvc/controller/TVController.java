package com.xai.patterns.mvc.controller;

import com.xai.patterns.mvc.model.TV;
import com.xai.patterns.mvc.service.TVService;

//controller are the workers
//that decides what to do and handles data to and from model to the view
public class TVController extends RemoteController {

	TV tv;
	
	public TVController(TV tv){
		this.tv = tv;
	}

	@Override
	public void keyIsDown(char key) {
		if(key == 'w'){
			int nextChannel = TVService.getCurrentChannel(tv) + 1;
			TVService.changeChannel(tv, nextChannel);
		}
	}
	
}
