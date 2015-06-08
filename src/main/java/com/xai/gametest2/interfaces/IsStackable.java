package com.xai.gametest2.interfaces;

public interface IsStackable {
	void setMaxStack(int maxStack);
	int setStack(int stack);	// return val if over stack
	int getStack();
	
	boolean isOverStack(int stack);
	boolean removeStack(int stack);
}
