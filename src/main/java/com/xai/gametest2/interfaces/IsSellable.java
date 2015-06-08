package com.xai.gametest2.interfaces;

/**
 * An interface shouldn't have variables because it cannot be instanced
 * @author stace2405
 *
 */
public interface IsSellable {
	int getMaxPrice();
	void setMaxPrice(int maxPrice);
	boolean sell();
}
