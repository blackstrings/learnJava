package com.xai.patterns.mvc.controller;

import com.xai.patterns.mvc.model.TVModel;
import com.xai.patterns.mvc.view.TVView;

//controller are the workers
//that decides what to do and handles data to and from model to the view
public class TVController {

	TVModel tvModel;
	TVView tvView;
	
	//when tvController is created, it will assume that tvModel and tvView
	//has been created and is available
	public TVController(TVModel tv, TVView tvView){
		this.tvModel = tvModel;
		this.tvView = tvView;
	}

	public void updateView() {
		tvView.display(tvModel);
	}
	
}
