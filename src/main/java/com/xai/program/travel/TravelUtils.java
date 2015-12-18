package com.xai.program.travel;

public class TravelUtils {

	public static void print(String str){
		System.out.println(str);
	}
	
	public static void setEnvs(int day, User user, EnvFactory envFac){
		if(day%3==0){	//every 3 days get new env from pool
			user.setEnv(envFac.getRandomEnvs());
		}
	}
}
