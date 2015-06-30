package com.xai.program.trails;

public class TrailsDemo {

	public static void main(String [] args){
		int i;
		
		//simulate level
		Level level = new Level();
		level.add(BranchFactory.getB1());
		level.add(BranchFactory.getB2());
		level.add(BranchFactory.getB2());	//append another branch like b2
		
		//custom connect
		level.connect(0,1);
		level.connect(0,2);	//branch0 now has connection to 1 and 2
		level.connect(2, 0);
		
		//create marker
		Marker marker = new Marker();
		
		//place and move marker around
		TileLevelController c = new TileLevelController();
		c.setLevel(level);
		c.forceNewMarkerPos(marker, new int[]{0,0,0}); //[branch, trail, tile]
		System.out.println(marker);
		
		i=0;
		int roll = 39;
		while(i<roll){
			int[] testReturnNewPos = c.moveForward(marker); //once
			if(testReturnNewPos != null){
				i++;
			}else{
				System.out.println("end of branch overflow");
				i=19;	//force stop loop
			}
		}
		
		System.out.println(marker);
		//controller moves marker, marker doesn't need to know about the nodes
		
	}
}
