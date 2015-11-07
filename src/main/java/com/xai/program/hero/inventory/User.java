package com.xai.program.hero.inventory;

public abstract class User implements IDamagable, IFixable, IInventory, IStatusable, IItemReceiver {
	
	public abstract void use(Item item, Object target);
	public abstract void use(String searchKey, Object target);
	
	public abstract void getUserStatus();
}
