package com.xai.program.hero.inventory;

public abstract class User implements IDamagable, IFixable, IInventory {
	
	@Override
	public abstract void modHP(int amt);
	
	public abstract void useTool(ToolItem toolItem);
	
	@Override
	public abstract void applyTool(ToolItem toolItem);
}
