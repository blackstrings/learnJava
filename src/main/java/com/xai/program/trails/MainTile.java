package com.xai.program.trails;

import java.util.ArrayList;
import java.util.List;

import com.xai.program.tiles.model.tileType.Type;
import com.xai.program.tiles.model.tileType.TypeFactory;

public class MainTile implements ITile {

	//should never need to reference its trail, bad design
	//private Trail currTrail;
	Type type;
	
	public MainTile(Type type){
		this.type = type;
	}
	
	public Type getType(){
		return type;
	}
	public void setType(Type type){
		this.type = type;
	}

	@Override
	public void executeEvent() {
		System.out.println("event executed type:" + type);
	}
	

	
}
