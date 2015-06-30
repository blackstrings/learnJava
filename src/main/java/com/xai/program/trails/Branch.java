package com.xai.program.trails;

import java.util.ArrayList;
import java.util.List;

public class Branch {

	private List<Trail> Trails;
	private List<Integer> frontBranchIds;
	private List<Integer> backBranchIds;

	public Branch(){
		Trails = new ArrayList<Trail>();
		frontBranchIds = new ArrayList<Integer>();
		backBranchIds = new ArrayList<Integer>();
	}
	
	public void add(Trail trail){
		Trails.add(trail);
	}
	
	public Trail getFirstTrail(){
		return Trails.get(0);
	}
	
	public List<Trail> getTrails() {
		return Trails;
	}

	public void setTrails(List<Trail> Trails) {
		this.Trails = Trails;
	}
	
	public void addFrontBranchId(int id){
		frontBranchIds.add(id);
	}

	public List<Integer> getFrontBranchIds() {
		return frontBranchIds;
	}
	
	public void addBackBranchId(int id){
		backBranchIds.add(id);
	}

	public void setNextBranchIds(List<Integer> nextBranchIds) {
		this.frontBranchIds = nextBranchIds;
	}

	public List<Integer> getBackBranchIds() {
		return backBranchIds;
	}

	public void setBackBranchIds(List<Integer> backBranchIds) {
		this.backBranchIds = backBranchIds;
	}
	

}
