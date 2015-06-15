package com.xai.ddd.dao;

import com.xai.ddd.domain.Bank;

//Save as DAO interface
public interface BankDao {
	public void add(Bank bank);
	public void update(Bank bank);
	public void remove(Bank bank);
	public Bank getBankById(long bankId);
}
