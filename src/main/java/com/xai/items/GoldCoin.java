package com.xai.items;

public class GoldCoin extends Coin {

	private int _FACEVALUE = 10;
	
	public GoldCoin(){
		setDefault(getClass().getSimpleName(), _FACEVALUE);
	}
	
	public GoldCoin(int count){
		setDefault(getClass().getSimpleName(), _FACEVALUE);
		add(count);
	}

}
