package com.xai.program.tiles.model.tileType;

import java.util.ArrayList;
import java.util.List;

import com.xai.program.tiles.model.tileType.Type;

public class TypeFactory {

	public static List<Type> getAllPossibleTypes(){
		List<Type> allTypes = new ArrayList<Type>();
		for(Type type : Type.values()){
			allTypes.add(type);
		}
		return allTypes;
	}
}
