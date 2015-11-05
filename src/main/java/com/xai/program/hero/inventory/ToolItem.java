package com.xai.program.hero.inventory;

public class ToolItem extends Item{

	private int maxStack = 0;	//maxStack this item can be stacked
	private int currStack = 0;	//tracks the current stack per use
	private int effectAmt = 0;	//per consumption this is the amt applied
	
	/**
	 * Basic Items that effect hp
	 * @param name
	 * @param effectAmt
	 * @param maxStack
	 */
	public ToolItem(String name, int effectAmt, int maxStack){
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
	public boolean useOn(Object targetUseOn){
		if(currStack > 0){	//check stack before allowing to use
			
			IFixable fixableObj = (IFixable) targetUseOn;
			fixableObj.applyTool(this);
			currStack--;	//after each use deduct the stack
			
			//update status
			System.out.println("applied " + name + " effect: " 
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

	
}
