package com.xai.gametest2;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.xai.gametest2.utils.Utils;
import com.xai.gametest2.utils.Utils.Type;

public class Reel extends Gear {
	
	private static final Logger logger = Logger.getLogger(Reel.class);
	
	/**
	 * Each reel has a line capacity limit
	 */
	private double maxLineCapacity = 0.0;
	
	private FishingLine fishingLine;
	
	/**
	 * each reel can only support certain line types (lbs)
	 */
	private List<FishingLineType> lineTypeSupportList;
	
	/**
	 * Modify Constructor
	 * @param type
	 */
	public Reel(Type type){
		quickPick(type);
	}

	/**
	 * default Constructor - for facotry to use
	 */
	public Reel(){}
	
	/**
	 * Get fishing line
	 * @return
	 */
	public FishingLine getFishingLine(){
		if(fishingLine != null){
			return fishingLine;
		}else{
			return null;
		}
		
	}

	/**
	 * Equip fishing line
	 * @param fishingLine
	 * @return
	 */
	public boolean addFishingLine(FishingLine fishingLine){
		
		// fishingLine is not equip
		if(fishingLine != null){

			// does reel support line type
			if(isLineTypeSupported(fishingLine.getLineType()) ){
				
				// check if fishingLine exceeds reel capacity support
				if( !(fishingLine.getLength() > maxLineCapacity)){
					
					// add fishingLine
					this.fishingLine = fishingLine;
					return true;
					
				}else{	// fishingLine exceeds reel capacity
					
					return false;
					
				}
				
			}else{	// lineType not supported
				
				return false;
				
			}
			
		}else{	
			// there's already a fishingLine -prompt to unequip first
			return false;
			
		}
	}
	
	/**
	 * set reel capacity
	 * @param maxLineCapacity
	 */
	public void setMaxLineCapacity(double maxLineCapacity){
		this.maxLineCapacity = maxLineCapacity;
	}
	public double getMaxLineCapacity(){
		return this.maxLineCapacity;
	}
	
	/**
	 * Snap line (cut line)
	 * @param lengthToSnap
	 */
	public void snapLine(double lengthToSnap){
		
		if(!fishingLine.isEmpty()){
			
			double length = fishingLine.getLength();
			
			if(length >= lengthToSnap){
				length -= lengthToSnap;
				fishingLine.setLength(length);
				
				/* if you design it right you should never have to 
				 * set an outside class's boolean
				 * as it is bad design
					if(length <= 0.0){
						isLineEmpty = true;
						length = 0.0;
					}
				*/
				logger.info("Line snapped");
			}else{ // should never reach this but in case lengthToSnap is greater
				fishingLine.setLength(0.0);
			}
		}
	}
	
	/**
	 * Quick reel selection using mod constructor
	 * @param type
	 */
	public void quickPick(Type type){
		if(type.toString().toLowerCase() == "standard"){
			
			// set properties
			setName("Standard Reel");
			setRarity(1);
			setDurability(10);
			
			// set local properties
			double lineLength = 25.0;
			setMaxLineCapacity(lineLength);
			setLineTypeSupport(FishingLineType.LBS01);
			
			// put new line on reel
			FishingLine newFishingLine = new FishingLine(FishingLineType.LBS01, lineLength);
			addFishingLine(newFishingLine);
			
		}else if(type.toString().toLowerCase() == "amateur"){
			
			// set properties
			setName("Basic Amateur Reel");
			setRarity(1);
			setDurability(10);
			double lineLength = 30.0;
			setMaxLineCapacity(lineLength);
			setLineTypeSupport(FishingLineType.LBS02);
			
			// put new line on reel
			FishingLine newFishingLine = new FishingLine(FishingLineType.LBS02, lineLength);
			addFishingLine(newFishingLine);
			
		}else if(type.toString().toLowerCase() == "pro"){
			
			// set properties
			setName("Basic Pro Reel");
			setRarity(1);
			setDurability(10);
			double lineLength = 55.0;
			setMaxLineCapacity(lineLength);
			setLineTypeSupport(FishingLineType.LBS04);
			FishingLine newFishingLine = new FishingLine(FishingLineType.LBS04, lineLength);
			addFishingLine(newFishingLine);
			
		}else if(type.toString().toLowerCase() == "custom"){
			
			// set properties
			setName("Basic Custom Reel");
			setRarity(1);
			setDurability(10);
			double lineLength = 25.0;
			setMaxLineCapacity(lineLength);
			
			//supports 3 lines
			setLineTypeSupport(FishingLineType.LBS01);
			setLineTypeSupport(FishingLineType.LBS02);
			setLineTypeSupport(FishingLineType.LBS04);
			FishingLine newFishingLine = new FishingLine(FishingLineType.LBS04, lineLength);
			addFishingLine(newFishingLine);
			
		}else{	// default
			
			// set properties
			setName("Basic Standard Reel");
			setRarity(1);
			setDurability(10);
			double lineLength = 25.0;
			setMaxLineCapacity(lineLength);
			setLineTypeSupport(FishingLineType.LBS01);
			FishingLine newFishingLine = new FishingLine(FishingLineType.LBS01, lineLength);
			addFishingLine(newFishingLine);
			
		}
	}
	
	/**
	 * set reel's line type support
	 * @param type
	 */
	public void setLineTypeSupport(FishingLineType type){
		// create new list if not already
		if(lineTypeSupportList == null){
			lineTypeSupportList = new ArrayList<FishingLineType>();
		}
		
		// check no duplicate
		if(isLineTypeNotDuplicate(type)){
			lineTypeSupportList.add(type);
		}
		
	}
	
	/**
	 * check reel's line type support
	 * @param type
	 * @return
	 */
	private boolean isLineTypeSupported(FishingLineType type){
		int i=0;
		while(lineTypeSupportList.size() > i){
			if(type == lineTypeSupportList.get(i)){
				return true;
			}
			i++;
		}
		return false;
	}
	
	/**
	 * Check line type support insert duplication
	 * @param type
	 * @return
	 */
	private boolean isLineTypeNotDuplicate(FishingLineType type){
		int i = 0;
		while(i < lineTypeSupportList.size()){
			// check if there is a match
			if(type == lineTypeSupportList.get(i)){
				return false;
			}
		}
		// no duplicate
		return true;
	}
	
	public String toString(){
		return getName() 
				+ ", LineCapacity: " + getMaxLineCapacity() 
				+ ", " +  fishingLine.toString();
	}
	
	
}
