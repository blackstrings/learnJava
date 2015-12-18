package com.xai.program.travel;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class EnvFactory {
	
	private int MAXPOOLSIZE = 20;
	private List<Environment> envPool;
	private int MAXRANDENV = 4;
	
	public EnvFactory(){
		envPool = new ArrayList<Environment>();
		populatePool();
	}
	
	private void populatePool(){
		int counter = 0;
		Random rand = new Random();
		int randIndex;
		Environment[] envs = Environment.values();
		int envLength = envs.length;
		
		while(counter < MAXPOOLSIZE){
			randIndex = rand.nextInt(envLength);
			envPool.add(envs[randIndex]);	//get rand enum value into pool
			counter++;
		}
	}
	
	public List<Environment> getRandomEnvs(){
		Random rand = new Random();
		int num = rand.nextInt(MAXRANDENV);
		
		List<Environment> randEnvs = new ArrayList<Environment>();
		do{
			randEnvs.add(envPool.remove(0));	//pop env in pool into randEnvs
			num--;
		}while(envPool.size() > 0 && num > 0);
		
		//refill the pool with more values
		if(envPool.isEmpty()){
			populatePool();
		}
		
		return randEnvs;
	}
}
