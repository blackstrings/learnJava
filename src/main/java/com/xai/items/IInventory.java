package com.xai.items;


public interface IInventory {
	public int getSlotCapacity();
	public void setSlotCapacity(int maxSlots);
	public int getSlotsRemaining();
	public int getSlotsUsed();
	public void setSlotsUsed(int slotsUsed);
	public boolean isSlotCapacityFull(Item item);
	public void updateSlotCapcityUsage(int itemSlotsCoverage);
}
