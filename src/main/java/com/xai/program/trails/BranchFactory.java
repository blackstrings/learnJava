package com.xai.program.trails;

public class BranchFactory {

	public static Branch getB1(){
		//create tiles into trail
		int i;
		Trail t1 = new Trail();
		for(i=0; i<5; i++){
			t1.add(new MainTile());
		}
		
		//create tiles into trail
		Trail t2 = new Trail();
		for(i=0; i<5; i++){
			t2.add(new MainTile());
		}
		
		//create branch add trail
		Branch b1 = new Branch();
		b1.add(t1);
		b1.add(t2);
		
		return b1;
	}
	
	public static Branch getB2(){
		//create tiles into trail
		int i;
		Trail t1 = new Trail();
		for(i=0; i<3; i++){
			t1.add(new MainTile());
		}
		
		//create tiles into trail
		Trail t2 = new Trail();
		for(i=0; i<3; i++){
			t2.add(new MainTile());
		}
		
		//create branch add trail
		Branch b1 = new Branch();
		b1.add(t1);
		b1.add(t2);
		
		return b1;
	}
	
}
