package com.xai.dataStructure;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class DataTestDemo {
	
	static class Side{
		public Side(){
			type = "steel";
			steel = false;
			color = "blue";
			bottomTrim = "false";
		}
		private String type;
		public String getType(){ return type; }
		public void setType(String steel){ this.type = type;}
		
		private boolean steel;
		public void setSteel(boolean steel){this.steel = steel;}
		public boolean getStee(){return steel;}
		
		private String color;
		public String getColor() {return color;}
		public void setColor(String color) {this.color = color;}
		
		private String bottomTrim;
		public String getBottomTrim() {return bottomTrim;}
		public void setBottomTrim(String bottomTrim) {this.bottomTrim = bottomTrim;}
	}

	@SuppressWarnings({ "unused", "rawtypes", "unchecked" })
	public static void main(String [] args){

		//---------------------------------------------TEST DATA INJECTION
		//iterate through all sidings, for each side, gather all info about side1 under one map???
		//i.e. has steel side, has steel wainscot, has bottom trim, wainscot and side are same color
		
		//main siding 4 sides with steel
		HashMap<String, Side> Siding1 = new HashMap<String, Side>();	//main siding
		//put 4 sides into siding 1
		for(int i=1; i<=4; i++){
			Side s = new Side();
			s.setSteel(true);
			s.setType("steel");
			s.setColor("blue");
			Siding1.put("sideId"+i, s);
		}
		
		//wainscot siding only 2 side with steel wainscot
		HashMap<String, Side> Siding2 = new HashMap<String, Side>();	//main siding
		for(int i=1; i<=2; i++){
			Side s = new Side();
			s.setSteel(true);
			s.setType("steel");
			s.setColor("blue");
			Siding2.put("sideId"+i, s);
		}
		
		//crate tracker
		HashMap<String, HashMap<String, Boolean>> sideTracker = new HashMap();
		for(int i=1; i<=Siding1.size(); i++){	//get max sides from Siding1
			HashMap<String, Boolean> tempHashMap = new HashMap();
			tempHashMap.put("hasSteelSide", true);
			tempHashMap.put("hasBottomTrim", false);
			tempHashMap.put("hasSteelWainscot", false);
			tempHashMap.put("hasSameColor", false);
			sideTracker.put("side"+i, tempHashMap);
		}
		
		HashMap myHm = new HashMap();
		myHm.put("Siding1", new HashMap());
		
		//check
		for(String key : sideTracker.keySet()){
			
			HashMap<String, Boolean> tempHM = sideTracker.get(key);
			
		
		}
		/*
		if(side1 has steel){
			sideTracker.get("side1").put("hasSteelSide", value)
		}
		*/
		
		//put all Sidings into one hashMap
		HashMap<String, HashMap<String, HashMap<String, Boolean>>> estimation = new HashMap<String, HashMap<String, HashMap<String, Boolean>>>();	
		//estimation.put("Siding1", Siding1);
		//estimation.put("Siding2", Siding2);
		
		
		
		
		//test
		if(sideTracker.get("side1").get("hasSteelSide")){
			System.out.println("yes it has steel sides");
		}
		
		//---------------------------------------- END OF TEST DATA INJECTION --- //
		
		
		for(String sidingId : estimation.keySet()){	//iterate through each side and gather info
			
			HashMap<String, HashMap<String, Boolean>> tempSiding = estimation.get(sidingId);
			for(String sideId : tempSiding.keySet()){
				HashMap<String, Boolean> side = tempSiding.get(sideId);
				sideTracker.get(sideId).put("hasSteelWainscot", side.get("hasSteelWainscot"));
			}
			
			int debugStopPoint = 0;
		}
		
		//TODO loop through each design so you get the following output for each side
		HashMap<String, Boolean> side1 = new HashMap<String, Boolean>();
		side1.put("hasBottomTrim", true);
		side1.put("hasSteelWainscot", true);
		side1.put("hasSteelSide", true);
		side1.put("hasSameColor", true);
		
		sideTracker.put("side1", side1);
		
		//iterate through the collector hashmap
		Iterator iter = sideTracker.keySet().iterator();
		for(String k : sideTracker.keySet()){
			
			HashMap<String, Boolean> temp = sideTracker.get(k);
			
			boolean hasSteelSide = false;
			boolean hasBottomTrim = false;
			boolean hasSteelWainscot = false;
			boolean hasSameColor = false;
			
			//set the the values
			if(temp.containsKey("hasSteelSide")){
				hasSteelSide = temp.get("hasSteelSide");
			}
			if(temp.containsKey("hasBottomTrim")){
				hasBottomTrim = temp.get("hasBottomTrim");
			}
			if(temp.containsKey("hasSteelWainscot")){
				hasSteelWainscot = temp.get("hasSteelWainscot");
			}
			if(temp.containsKey("hasSameColor")){
				hasSameColor = temp.get("hasSameColor");
			}
			if(hasSteelSide){
				System.out.println("steel");
			}
			
			//now that we gathered all the info we need about this side, determine the bottom trim for this side
			if(hasSteelSide && hasBottomTrim){
				if(hasSteelWainscot && !hasSameColor){ //has bottomTrim but steel side and wainscot are different colors
					
					//remove main siding bottom trim and replace
					//using wainscot as bottom trim color
					
					
				}else{ //has bottom trim && steel side and wainscot have same color
					
					//use main siding bottom trim, do nothing since it has already been set
				
				}
			}
			
			int num = 0;
		}
//		
//		while (iter.hasNext()) {
//
//			//get the treeMap key
//			String str = (String) iter.next();
//			//get treeMap of siding 1
//			TreeMap<String, Boolean> tt = (TreeMap) hashMap.get(str);
//			
//			Collection c = tt.values();
//			Iterator iter2 = c.iterator();
//			while(iter2.hasNext()){
//				
//			}
//			
//			
//			int num = 5;
//		}
	}
}
