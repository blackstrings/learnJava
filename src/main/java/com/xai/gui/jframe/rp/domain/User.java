package com.xai.gui.jframe.rp.domain;

import java.util.ArrayList;
import java.util.List;

public class User {

	private List<Mon> mons;
	
	public User(){
		mons = new ArrayList<Mon>();
	}
	
	public void add(Mon mon){
		mons.add(mon);
	}
	
	public void removeMon(int index){
		try{
			mons.remove(index);
		}catch(ArrayIndexOutOfBoundsException e){
			System.out.println("remove failed - index " + index + " not exist");
		}
		
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
