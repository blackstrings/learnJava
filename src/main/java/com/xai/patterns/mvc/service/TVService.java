package com.xai.patterns.mvc.service;

import com.xai.patterns.mvc.model.TV;

public class TVService {

	public static void changeChannel(TV tv, int channel){
		tv.setChannel(channel);
	}
	
	public static int getCurrentChannel(TV tv){
		return tv.getChannel();
	}
	
}
