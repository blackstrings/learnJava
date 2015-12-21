package com.xai.gui.jframe.rp;

import java.util.ArrayList;
import java.util.List;

import com.xai.gui.jframe.rp.domain.Mon;

public class User {

	List<Mon> mons;
	
	public User(){
		mons = new ArrayList<Mon>();
	}
	
	public void add(Mon mon){
		mons.add(mon);
	}
	
	public Mon get(int id){
		try{
			return mons.get(id);
		}catch(ArrayIndexOutOfBoundsException e){
			System.out.println(e);
			return null;
		}
	}
	
	public String toString(){
		return mons.toString();
	}
}
