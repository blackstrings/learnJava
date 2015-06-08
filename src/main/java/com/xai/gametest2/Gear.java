package com.xai.gametest2;

import com.xai.gametest2.interfaces.IsDegradable;
import com.xai.gametest2.interfaces.IsRare;
import com.xai.gametest2.interfaces.IsSellable;

public abstract class Gear extends Item implements IsSellable, IsDegradable{

	// TODO -- what properites to set locally vs into the database
	private boolean canSell = true;
	
	@Override
	public int getDurability() {
		return getProp(Prop.DURABILITY);
	}
	
	@Override
	public void setDurability(int durability) {
		setProp(Prop.DURABILITY, durability);
	}
	
	@Override
	public int getMaxDurability() {
		return getProp(Prop.MAX_DURABILITY);
	}
	
	@Override
	public void setMaxDurability(int maxDurability) {
		setProp(Prop.MAX_DURABILITY, maxDurability);
	}
	
	@Override
	public int getMaxPrice() {
		return getProp(Prop.MAX_PRICE);
	}
	
	@Override
	public void setMaxPrice(int maxPrice) {
		setProp(Prop.MAX_PRICE, maxPrice);
	}
	
	@Override
	public boolean sell(){
		if(canSell){
			//access bank and put money there
			
			return true;
		}else{
			return false;
		}
	}
	

	
}
