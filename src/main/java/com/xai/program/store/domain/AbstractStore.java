package com.xai.program.store.domain;

public abstract class AbstractStore implements Store {
	
	private int storeId;
	private double cash;
	
	public AbstractStore(int storeId, double cash){
		this.storeId = storeId;
		this.cash = cash;
	}
	
	@Override
	public void sell(Product product){
		cash += product.getPrice();
	}

	public int getStoreId() {
		return storeId;
	}

	public void setStoreId(int storeId) {
		this.storeId = storeId;
	}

	public double getCash() {
		return cash;
	}

	public void setCash(double cash) {
		this.cash = cash;
	}
	
}
