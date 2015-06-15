package com.xai.patterns.mvc.view;

import com.xai.patterns.mvc.model.TVModel;

public class TVView {
	
	public void display(TVModel tv){
		System.out.println("Current Channel: " + tv.getChannel() 
				+ " - Brand : " + tv.getBrand());
	}
	
}
