package com.xai.ddd;

public interface IBankRepository {
	public void add(Bank bank);
	public void update(Bank bank);
	public void remove(Bank bank);
	public Bank getBankById(long bankId);
}
