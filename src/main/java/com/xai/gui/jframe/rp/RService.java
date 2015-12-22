package com.xai.gui.jframe.rp;

import java.util.Random;

import com.xai.gui.jframe.rp.dao.MonDao;
import com.xai.gui.jframe.rp.dao.MonDaoImpl;
import com.xai.gui.jframe.rp.domain.Mon;
import com.xai.gui.jframe.rp.domain.User;

public class RService {
	
	MonDao monRepo;
	User user;
	
	public RService(){
		init();
	}
	
	private void init(){
		monRepo = new MonDaoImpl();
		user = new User();
	}
	
	public MonDao getMonRepo(){
		return monRepo;
	}
	
	public void addToUser(Mon mon){
		user.add(mon);
	}
	
	public Mon getRandMon(){
		Random rand = new Random();
		Integer randId = rand.nextInt(monRepo.getSize()) + monRepo.BASE_ID;
		return monRepo.getMon(randId);	//return copy
	}
	
	public Mon getMonById(int id){
		return monRepo.getMon(id);
	}
	
	public boolean match(Mon m1, Mon m2){
		if(m1.getLvl() > m2.getLvl()){
			return true;
		}
		return false;
	}
	
	public User getUser(){
		return user;
	}
	
}
