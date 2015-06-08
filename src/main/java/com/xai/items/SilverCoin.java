package com.xai.items;

public class SilverCoin extends Coin {

	private int _FACEVALUE = 5;
	
	public SilverCoin(){
		setDefault(getClass().getSimpleName(), _FACEVALUE);
	}
	
	public SilverCoin(int count){
		setDefault(getClass().getSimpleName(), _FACEVALUE);
		add(count);
	}
	

}
