package com.xai.gametest2;

/**
 * Fishing line has no durability so it doesn't degrade
 * only has length and line type
 *
 */
public class FishingLine extends Gear {
	
	private double length = 0.0;
	private FishingLineType lineType;
	
	/**
	 * Default Construct
	 */
	public FishingLine(){
		setProp(Prop.STACKABLE, false);
	}
	
	/**
	 * Modify Constructor
	 * @param lineType
	 */
	public FishingLine(FishingLineType lineType, double length){
		setProp(Prop.NAME, lineType.val() + "LBS Line");
		setLength(length);
		setLineType(lineType);
	}

	// length of total fishing line
	public double getLength() {
		return length;
	}

	public void setLength(double length) {
		//to prevent negative length
		if(length <= 0){
			this.length = 0.0;
		}else{
			this.length = length;
		}
	}
	
	// add more line to existing line
	// reel class should validate line type before calling this method
	public void addLine(double length){
		this.length += length;
	}

	// Line type
	public void setLineType(FishingLineType lineType){
		this.lineType = lineType;
	}
	public FishingLineType getLineType(){
		return lineType;
	}
	
	public boolean isEmpty(){
		if(length <= 0){
			return true;
		}else{
			return false;
		}
	}
	
	public String toString(){
		return getName() 
				+ ", CurrentLine: " + getLength();
	}

}
