package com.xai.program.hero.inventory;

public class ToolItem extends Item{

	/**
	 * Basic Items that effect hp
	 * @param name
	 * @param maxStack
	 */
	public ToolItem(String name,int maxStack){
		super(name, maxStack);
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
