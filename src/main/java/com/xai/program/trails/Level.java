package com.xai.program.trails;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Level {
	private List<Branch> branches;
	
	public Level(){
		branches = new ArrayList<Branch>();
	}
	
	public void add(Branch branch){
		branches.add(branch);
	}

	public List<Branch> getBranches() {
		return branches;
	}

	public void setBranches(List<Branch> branches) {
		this.branches = branches;
	}
	
	public MainTile getTile(int[] tilePos){
		int branchId = tilePos[0];
		int trailId = tilePos[1];
		int tileId = tilePos[2];
		
		return branches.get(branchId).getTrails().get(trailId).getMainTiles().get(tileId);
	}
	
	//test
	public int[] getNextMarkerPos(int[] currPos){
		int branchId = currPos[0];
		int trailId = currPos[1];
		int tileId = currPos[2];
		
		Branch branch = branches.get(branchId);
		Trail trail = branch.getTrails().get(trailId);
		List<Trail> trails = branch.getTrails();
		
		//check can go to next tile
		if(!(tileId + 1 >= trail.getMainTiles().size())){	
			//more tiles are available
			currPos[2] = tileId += 1;
			return currPos;
		//check can go to next trail
		}else if(!(trails.indexOf(trail) + 1 >= trails.size()) ){
			//more trails in branch
			currPos[1] = trailId += 1;
			currPos[2] = 0;	//first tile of trail
			return currPos;
		//end of trails also means end of branch, 
		//check if branch has connecitons
		}else if(branch.getFrontBranchIds() != null 
				&& branch.getFrontBranchIds().size() > 0){	//branch has connection?
			
			//multiple connections detected
			if(branch.getFrontBranchIds().size() > 1){	
				
				//choose which branch to go because multiple branches
				Scanner scanner = new Scanner(System.in);
				
				System.out.println("Multiple paths detected");
				System.out.println("choose a branchId under: " + (branch.getFrontBranchIds().size()));
				
				int inputId = scanner.nextInt();
				int defaultId = 0;
				inputId = inputId >= branch.getFrontBranchIds().size() ? defaultId : inputId ;
				
				currPos[0] = branch.getFrontBranchIds().get(inputId);
				currPos[1] = 0; //first trail
				currPos[2] = 0;	//first tile in trial
				return currPos;
			}else{ //branch has one branch connection
				
				currPos[0] = branch.getFrontBranchIds().get(0); //first id in list
				currPos[1] = 0; //first trail
				currPos[2] = 0;	//first tile in trial
				
				return currPos;
			}
			
		}
		
		return null;

	}
	
	public void connect(int branchId1, int branchId2){
		//connect branch2 to branch1
		branches.get(branchId1).addFrontBranchId(branchId2);
		branches.get(branchId2).addBackBranchId(branchId1);
	}
	
}
