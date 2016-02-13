package com.xai.program.tictac;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class TicTacDemo {

	
	public static void main(String [] args){
		
		Integer row = 3;
		Integer col = 3;
		Integer gb[][] = new Integer[row][col];
		defaultGB(gb);
		
		List<Integer> prePopulatedSelections = new ArrayList<Integer>();
		prePopulatedSelections.add(1);
		prePopulatedSelections.add(2);
		prePopulatedSelections.add(1);
		prePopulatedSelections.add(2);
	
		fillInRandomSlots(gb, prePopulatedSelections, row, col);
		printGrid(gb);
		
		int curP = 2;	//hard code p
		
		if(!checkCurPCanW(gb, curP)){
		
			//else random pick an unused slot
			List<Integer[]> unusedSlots;
			unusedSlots = getAllUnusedCoords(gb);
			randomPickUnusedSlot(gb, unusedSlots);
			printGrid(gb);
		
		}
		
	}
	
private static void fillInRandomSlots(Integer[][] gb, List<Integer> prePopulatedSelections, int row, int col){
		
		int maxCount = prePopulatedSelections.size();
		int tokensLeft = prePopulatedSelections.size();
		int remainingSlots = row*col;
		
		Random rand = new Random();	
		
		for(int i=0; i<3; i++){
			for(int k=0; k<3; k++){
				
				//if we are near end and not all tokens are used
				if(!(remainingSlots == tokensLeft)){
					if(rand.nextInt(2) == 0){	//random if token should be used 50/50
						gb[i][k] = prePopulatedSelections.remove(0);
						tokensLeft--;
					}
				}else{
					//every iteration now will use remaing tokens
					gb[i][k] = prePopulatedSelections.remove(0);
					tokensLeft--;
				}
				
				if(prePopulatedSelections.isEmpty()){break;}
				
				remainingSlots--;
			}
			
			if(prePopulatedSelections.isEmpty()){break;}
		}
	}
	
	private static boolean checkCurPCanW(Integer[][] gb, int curP){
		Integer[] row = new Integer[3];
		Integer[] col = new Integer[3];
		Integer[] diag = new Integer[3];
		
		Map<String, Integer[]> winnableRows = new HashMap<String, Integer[]>();
		Map<String, Integer[]> winnableCols = new HashMap<String, Integer[]>();
		Map<String, Integer[]> winnableDiags = new HashMap<String, Integer[]>();
		
		List<Map<String, Integer[]>> winableRCD = new ArrayList<Map<String, Integer[]>>();
		
		//scan all rows
		Integer i = 0;
		Integer k = 0;
		for(i=0; i<3; i++){
			for(k=0; k<3; k++){
				row[k] = gb[i][k];	//gather current row values
			}
			
			//per row iteration, we scan the row
			if(scanArr3IfCanWinInOneMove(row, curP)){
				winnableRows.put("r"+i,row);
			}
			
		}
		winableRCD.add(winnableRows);
		
		//scan all cols
		for(i=0; i<3; i++){
			for(k=0; k<3; k++){
				col[k] = gb[k][i];	//gather current col values
			}
			
			//per row iteration, we scan the row
			if(scanArr3IfCanWinInOneMove(col, curP)){
				winnableRows.put("c"+i,col);
			}
			
		}
		winableRCD.add(winnableCols);
		
		
		//1strow
		//if(gb[0][0] == curP && gb[0][1] == curP && gb[0][2] == curP)
			
		if(!winableRCD.isEmpty()){
			
			
			
			return true;
		}
		
		return false;
		
		
	}
	
	private static boolean scanArr3IfCanWinInOneMove(Integer[] arr, Integer curP){
		int count = 0;
		for(int i=0; i<3; i++){
			if(arr[0] == curP){
				count++;	//for each col with the curP, increment counter
			}else if(arr[0] == 0){ //check if there is a space not yet occupied
				count++;	
			}
		}
		
		if(count == 3){	//then yes one move in current row will allow curP to win
			return true;
		}
		return false;
	}
	
	private static void defaultGB(Integer[][] gb){
		for(Integer i=0; i<3; i++){
			for(Integer k=0; k<3; k++){
				gb[i][k] = 0;
			}
		}
	}
	
	private static void randomPickUnusedSlot(Integer[][] grid, List<Integer[]> us){
		Random rand = new Random();
		int randChoice = rand.nextInt(us.size());
		Integer[] coord = us.get(randChoice);
		
		grid[coord[0]][coord[1]] = 2;
	}
	
	private static List<Integer[]> getAllUnusedCoords(Integer[][] grid){
		//us = unused slots
		List<Integer[]> us = new ArrayList<Integer[]>();
		
		for(Integer i=0; i<3; i++){
			
			for(Integer k=0; k<3; k++){
				
				if(grid[i][k] == 0){
					Integer[] coord = new Integer[]{i,k};
					us.add(coord);
				}
			}
		}
		return us;
	}
	
	private static List<Integer[]> getUnUsedCoordsForOneRow(Integer[][] grid, Integer row){
		//us = unused slots
		List<Integer[]> us = new ArrayList<Integer[]>();
		
		for(Integer i=0; i<3; i++){
			
			if(grid[row][i] == 0){
				Integer[] coord = new Integer[]{row,i};
				us.add(coord);
			}
		}
		return us;
	}
	
	private static void printGrid(Integer gb[][]){
		for(Integer i=0; i<3; i++){
			for(Integer k=0; k<3; k++){
				System.out.print(gb[i][k]);
			}
			System.out.println();
		}
		System.out.println("----------");
	}
}
