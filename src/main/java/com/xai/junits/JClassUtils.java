package com.xai.junits;

public class JClassUtils {
	
	private static void someAdd(int num){
		num+=2;
		System.out.println("doing own stuff");
	}
	
	public static boolean canAdd(JClassObj obj){
		someAdd(obj.id);
		if(obj.id > 100){
			return true;
		}else{
			return false;
		}
	}
	
}
