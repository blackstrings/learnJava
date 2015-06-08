package com.xai.enumeration;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

public class ReverseLookUpDemo {

	public enum Status{
		WAITING(0),
		READY(1),
		SKIPPED(-1),
		COMPLETED(5);
		
		private static final Map<Integer, Status> lookup = new HashMap<Integer, Status>();
		
		static {
			for(Status s: Status.values()){	//itereate through all the enum values
				lookup.put(s.getCode(), s);	//put to map
			}
		}
		
		private int code;
		private Status(int code){
			this.code = code;
		}
		
		public int getCode(){return code;}
		public static Status get(int code){
			return lookup.get(code);
		}
	}
	
	//test
	public static void main(String []args){
		System.out.println(Status.get(1));
	}
	
}
