package com.xai.items;

public class BronzeCoin extends Coin {

	private int _FACEVALUE = 1;
	
	public BronzeCoin(){
		setDefault(getClass().getSimpleName(), _FACEVALUE);
		setFaceValue(_FACEVALUE);
	}
	
	public BronzeCoin(int count){
		setDefault(getClass().getSimpleName(), _FACEVALUE);
		add(count);
	}

}
