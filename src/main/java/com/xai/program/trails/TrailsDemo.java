package com.xai.program.trails;

/**
 * Version 2.0 no longer uses trails, just Branch and tiles right inside branches
 * @author xlao
 *
 */
public class TrailsDemo {

	/**
	 * The idea here is that the marker never actually gets put inside a level and is
	 * able to be kept separate from the level through a controller.
	 * The marker holds coordinate positions that can be mapped to the level tile positions.
	 * That is the key thing.
	 * @param args
	 */
	public static void main(String [] args){
		int i;
		
		//simulate level
		Level level = new Level();
		level.add(BranchFactory.getB1());
		level.add(BranchFactory.getB1());
		level.add(BranchFactory.getB1());	//append another branch like b2
		
		//custom connect branches
		//allows you to disconnect and connect to new branches
		level.connect(0,1);
		level.connect(0,2);	//branch0 now has connection to 1 and 2
		level.connect(2,0); //branch2 connects back to branch 0 and can run an infinity loop
		
		//create marker
		Marker marker = new Marker();
		
		//controller responsible to manipulate marker and set to tiles
		TileLevelController c = new TileLevelController();
		c.setLevel(level);
		c.forceNewMarkerPos(marker, new int[]{0,0,0}); //[branch, trail, tile]
		System.out.println(marker);
		
		i=0;
		int roll = 27;
		while(i<roll){
			int[] testReturnNewPos = c.moveForward(marker); //once
			if(testReturnNewPos != null){
				i++;
			}else{
				System.out.println("end of branch overflow");
				i=roll;	//force stop loop
			}
		}
		
		System.out.println(marker);
		//controller moves marker, marker doesn't need to know about the nodes
		
		
		//the marker is done moving
		//initiate event of tile marker is on
		c.executeTileEvent(marker);
		
		
		//implement a phase category that orders the phases
		//may need a phase collector
		//ex
		/*
		if(phaseCategoryA != empty)
			run all phaseCategoryA
			
		if(phaseCategoryB != empty)
			run all phaseCategoryB
		
		etc till you get to the last phases
		
		 */
	}
}
