package com.xai.program.trails;

public class BranchFactory {

	public static Branch getB1(){
		//create tiles into trail
		int i;
		/*
		Trail t1 = new Trail();
		t1.setMainTiles(MainTileFactory.getTiles(5));
		
		//create tiles into trail
		Trail t2 = new Trail();
		t2.setMainTiles(MainTileFactory.getTiles(3));
		
		//create branch add trail
		Branch b1 = new Branch();
		b1.add(t1);
		b1.add(t2);
		*/
		
		//create tiles into branch
		Branch b1 = new Branch();
		b1.setTiles(MainTileFactory.getTiles(5));
		
		return b1;
	}
	
}
