package com.xai.program.hero.inventory;

/**
 * Object can get a statusEffect
 *
 */
public interface IStatusable {
	public void applyStatus(StatusType type);
	public boolean hasStatus(StatusType type);
	public void removeSatus(StatusType type);
}
