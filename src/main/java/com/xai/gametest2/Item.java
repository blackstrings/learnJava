package com.xai.gametest2;

import com.xai.gametest2.interfaces.IsRare;
import com.xai.gametest2.interfaces.IsStackable;

/**
 * Every item is stackable, for those that shouldn't stack
 * use factory to call putP("stackable", false);
 * @author stace2405
 *
 */
public abstract class Item extends GameObject implements IsStackable, IsRare{
	
	public int getRarity() {
		return getProp(Prop.RARITY);
	}
	
	public void setRarity(int rarity) {
		setProp(Prop.RARITY, rarity);
	}
	
	public void setMaxStack(int maxStack){
		setProp(Prop.MAX_STACK, maxStack);
	}
	
	public int getMaxStack(){
		return getProp(Prop.MAX_STACK);
	}
	
	public int setStack(int stack){
		
		// check so we don't over stack
		if(!isOverStack(stack)){
			setProp(Prop.STACK, stack);
		}
		
		// overstack, so return the amt that tried to get added
		return stack;

	}
	
	public boolean isOverStack(int stack){
		int cur = getStack();
		if(cur + stack > getMaxStack()){
			return true;
		}
		return false;
	}
	
	public int getStack(){
		return getProp(Prop.STACK);
	}
	
	/**
	 * returns false if stack reaches zero;
	 * any function calling this should implement
	 * how to handle a false return when stack reaches zero
	 * such as deleting this item out of inventory
	 */
	public boolean removeStack(int stack){
		int cur = getProp(Prop.STACK);
		if(cur - stack > 0){
			cur -= stack;
			setProp(Prop.STACK, cur);
			return true;
		}else{
			setProp(Prop.STACK, 0);
			return false;
		}
	}
	
}
