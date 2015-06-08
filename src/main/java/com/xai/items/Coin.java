package com.xai.items;

public abstract class Coin extends Item {

	private static final int MIN = 0;
	private static final int MAX = 1000;
	private int count = 0;
	private int faceValue = 1;
	
	protected void setDefault(String name, int faceValue){
		setName(name);
		this.faceValue = faceValue;
	}
	
	/**
	 * Positive and Negative amount can be arguments.
	 * @param amount
	 */
	public void add(int amount){
		if(this.count + amount > MAX){
			this.count = MAX;
		}else if(this.count + amount < MIN){
			resetBalance();
		}else{
			this.count += amount;
		}
	}
	
	public void setFaceValue(int faceValue){
		this.faceValue = faceValue;
	}
	
	private int getFaceValue(){
		return this.faceValue;
	}
	
	public void resetBalance(){
		this.count = 0;
	}
	
	public int getCount(){
		return this.count;
	}

	public int getBalance() {
		return count * getFaceValue();
	}

	public void setBalance(int amount) {
		this.count = amount;
	}
	
	@Override
	public String toString(){
		return "" + this.count;
	}
	
}
