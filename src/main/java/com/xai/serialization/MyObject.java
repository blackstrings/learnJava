package com.xai.serialization;

import java.io.Serializable;

/**
 * For an object to become serializable, all field types must be serializable
 * To know if a field is serializable, it must implement the serializable class.
 * For fields that are not serializable or wish not to be serialized, put transient next to them
 * All rules above must be true for this MyObject to be properly serialized.
 */
public class MyObject implements Serializable {

	private static final long serialVersionUID = 1L;
	private String name;
	
	//transient means either this field is not serializable or
	//we do not want to serialize this field, so on deserialization the field will be default
	private transient int id;
	
	public MyObject(String name, int id){
		this.name = name;
		this.id = id;		//we choose not to serialize this field, so what stores here will not be store upon deserialize
	}
	
	public String toString(){
		return name + " : " + id;
	}
}
