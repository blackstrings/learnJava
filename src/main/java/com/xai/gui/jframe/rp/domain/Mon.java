package com.xai.gui.jframe.rp.domain;

public class Mon {

	private Integer id;
	private String name;
	private Integer lvl;
	
	public Mon(Integer id, String name, Integer lvl){
		this.setId(id);
		this.setName(name);
		this.setLvl(lvl);
	}
	
	public Mon(Mon mon){
		this.setId(mon.getId());
		this.setName(mon.getName());
		this.setLvl(mon.getLvl());
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String toString(){
		return "["+id+":"+name+"]";
	}

	public Integer getLvl() {
		return lvl;
	}

	public void setLvl(Integer lvl) {
		this.lvl = lvl;
	}



}
