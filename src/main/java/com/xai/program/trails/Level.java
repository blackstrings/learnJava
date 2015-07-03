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
		int tileId = tilePos[1];
		
		return branches.get(branchId).getTiles().get(tileId);
	}
	
	//test
	public int[] getNextMarkerPos(int[] currPos){
		int branchId = currPos[0];
		int tileId = currPos[1];
		
		Branch branch = branches.get(branchId);
		
		//check can go to next tile, basically checking if end of branch
		if(!(tileId + 1 >= branch.getTiles().size())){	//can go
			//more tiles are available
			currPos[1] = tileId += 1;	//update the currPos
			return currPos; 
			
		//check if branch has connections
		}else if(branch.getFrontBranchIds() != null 
				&& branch.getFrontBranchIds().size() > 0){	//branch has connection
			
			//multiple connections detected
			if(branch.getFrontBranchIds().size() > 1){	
				
				//choose which branch to go because multiple branches
				Scanner scanner = new Scanner(System.in);
				
				System.out.println("Multiple paths detected");
				String ids = "";
				for(int i=0; i<branch.getFrontBranchIds().size(); i++){
					ids += i + ",";
				}
				System.out.println("choose a branchId: " + ids);
				
				int inputId = scanner.nextInt();
				int defaultId = 0;
				inputId = inputId >= branch.getFrontBranchIds().size() ? defaultId : inputId ;
				
				currPos[0] = branch.getFrontBranchIds().get(inputId);
				currPos[1] = 0; //first tile in branch
				return currPos;
			}else{ //branch has one branch connection
				
				currPos[0] = branch.getFrontBranchIds().get(0); //first id in list
				currPos[1] = 0; //first tile in branch
				
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
