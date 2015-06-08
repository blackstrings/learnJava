package com.xai.gametest2;

import org.apache.log4j.Logger;

import com.xai.gametest2.utils.Utils;
import com.xai.gametest2.utils.Utils.Type;

/**
 * FishingRod.class has an attachment which can equip a reel
 * Reel.class has it's own attachment such as fishing line
 *
 */
public class FishingRod extends Rod {
	
	private static final Logger logger = Logger.getLogger(FishingRod.class);
	// attachments
	private Reel reel;
	
	//states
	private boolean isCast;
	private boolean isFishOn;
	
	/**
	 * Note: Line out is not directly linked to the reel's fishing line
	 * it's just a tracker of how much line is casted out
	 */
	private double lineout;
	
	/**
	 * Strength of the rod
	 */
	private Action action;
	
	/**
	 * Desired casting strength which the player can choose at will
	 * Unlike some fishing games, there will be no UI bar 
	 * that acts like a pendulum for player to tap to make a cast
	 */
	public enum CastingPower {
		SHORT(0.3), MED(0.6), LONG(1.0);
		private double val;
		CastingPower(double val){
			this.val = val;
		}
		private double val(){return val;}
	}
	
	public enum Action {
		FAST(0.3), MEDIUM(0.6), SLOW(1.0);
		private double factor;
		Action(double factor){
			this.factor = factor;
		}
		private double factor(){return factor;}
	}
	
	/**
	 * Default Constructor
	 * Fishing rod can have attachment(s)
	 * a reel
	 * a bait/lure
	 */
	public FishingRod(){}
	
	/**
	 * Modify Constructor - quick pick for now
	 * @param type
	 */
	public FishingRod(Type type){
		quickPick(type);	
	}
	
	/**
	 * Cast distance will eventually determined by a few factors
	 * the rod's action
	 * the reel's max fishing line
	 * the reels' current durability (the smoothness of the reel)
	 * the desired cast strength by the player
	 * the fishing line type (thicker line means lesser distance)
	 * the weight of the bait/lure
	 * @param castingPower
	 */
	public void cast(CastingPower castingPower){
		
		if(!isCast){
			
			logger.info("Casting..." + castingPower.toString() + " ");
			double lineLength = reel.getFishingLine().getLength();
			if(castingPower == CastingPower.SHORT){
				double min = 1.0;
				double max = lineLength * castingPower.val;
			
				// formula random = min + (max-min)
				double random = Utils.randomBetweenTwoDouble(min, max);
				lineout = random;
				
				// pass line out cast into reel
				// TODO
				
			}else if(castingPower == CastingPower.MED){
				double min = lineLength*CastingPower.MED.val;
				double max = lineLength*castingPower.val;
				double offset = max-min;
				
				// formula random = min + (max-min)
				double random = min + Math.ceil( (Math.random()*offset));
				lineout = random;
	
				// pass lineOut cast into reel
				
			}else if(castingPower == CastingPower.LONG){
				double min = lineLength*CastingPower.MED.val;
				double max = lineLength*castingPower.val;
				double offset = max-min;
				
				// formula random = min + (max-min)
				double random = min + Math.ceil( (Math.random()*offset));
				lineout = random;
				
				// pass line out cast into reel
			}
			
			isCast = true;
			logger.info( "lineout: " + lineout);
			
		}

	}
	
	public boolean getIsCast(){
		return isCast;
	}
	
	public void fishIsOn(){
		unCast();
		isFishOn = true;
	}
	public void fishIsOff(){
		isFishOn = false;
	}
	
	public void unCast(){
		isCast = false;
	}
	
	/**
	 * reel in line out
	 */
	public void reelIn(){
		
		// if rod is casted, has reel, and is not broken
		if(isCast && this.reel != null){
			
			// reel durability is not zero
			//if(reel.getProp(Prop.DURABILITY).equals(0.0) ){	//reel in should only reeel in nothing else
				
				double perReel = 2.0; // temporary method
				
				// if can reel in more lines
				if(lineout - perReel > 0){
					lineout -= perReel;
					logger.info("reeling in...Lineout: " + lineout);
					
				}else{
					lineout = 0;
					isCast = false;
					logger.info("reeling in...Lineout: " + lineout);
				}
				
				// TODO call reel to draw in line???
				//reel.drawLineIn();
			//}else{
				//reel.snapLine(lineout);
			//}
		}
	}
	
	/**
	 * Many factors can cause the fishing line to snap
	 * if when so, call reel to snap the current lineout
	 */
	public void snapLine(){
		if(isCast && reel != null){
			reel.snapLine(lineout);
			isCast = false;
		}
	}
	
	/**
	 * Quick Rod Selection (for now)
	 * the final method to use would be to load in rod properties from file/database
	 * @param type
	 */
	public void quickPick(Type type){
		if(type == Type.STANDARD){
			setName("Basic Standard Rod");
			setRarity(1);
			setAction(Action.SLOW);
			setLength(5.0);
		}else if(type == Type.AMATEUR){
			setName("Basic Amateur Rod");
			setRarity(1);
			setAction(Action.MEDIUM);
			setLength(6.0);
		}else if(type == Type.PRO){
			setName("Basic Pro Rod");
			setRarity(1);
			setAction(Action.FAST);
			setLength(7.0);
		}else if(type == Type.CUSTOM){
			setName("Basic Custom Rod");
			setRarity(1);
			setAction(Action.FAST);
			setLength(5.0);
		}
		
	}

	// rod action
	public Action getAction() {
		return action;
	}

	public void setAction(Action action) {
		this.action = action;
	}

	// get reel on rod
	public Reel getReel() {
		if(reel != null){
			return reel;
		}return null;
	}
	
	public void setReel(Reel reel) {
		this.reel = reel;
	}
	
	public String toString(){
		return "[" + getName() + ", " + reel.toString() + "]";
	}
}
