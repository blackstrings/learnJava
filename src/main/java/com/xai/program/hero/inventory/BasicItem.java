package com.xai.program.hero.inventory;

public class BasicItem extends Item implements HPEffector{

	private int maxStack = 0;	//maxStack this item can be stacked
	private int currStack = 0;	//tracks the current stack per use
	private int effectAmt = 0;	//per consumption this is the amt applied
	
	public BasicItem(String name, int effectAmt, int maxStack){
		super(name);
		this.effectAmt = effectAmt;
		this.maxStack = maxStack;
		this.currStack = maxStack;
	}
	
	/**
	 * returns false if item is empty
	 * true if there are still more stacks
	 */
	@Override
	public boolean use(User user){
		if(currStack > 0){	//check stack before allowing to use
			
			user.modHP(applyHPEffector());
			currStack--;	//after each use deduct the stack
			
			//update status
			System.out.println("applying " + name + " effect: " + effectAmt 
					+ ": remaining stack: " + currStack + "/" + maxStack);
			
			//check if stack is empty after usage
			if(currStack <= 0){
				return true; //empty
			}
			
			return false;	//not yet empty
		}
		
		System.out.println("item was empty to begin with, no effect applied");
		return true;	//empty
		
	}

	@Override
	public int applyHPEffector() {
		return effectAmt;
	}
	
}
