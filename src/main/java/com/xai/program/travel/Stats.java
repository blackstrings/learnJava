package com.xai.program.travel;

public class Stats {

	//total stats
	int totalStats = 3;
	public int l=0;
	public int i=0;
	public int s=0;
	
	public Stats(){}
	public Stats(int l, int i, int s){
		this.l = l;
		this.i = i;
		this.s = s;
	}
	
	//helps return the total stats this class carries
	//needs a better implementation
	public int getTotalStats(){
		return totalStats;
	}
}
