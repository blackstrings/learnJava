package com.xai.ddd;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;

public class BankRepositoryImpl implements IBankRepository {

	private final static Logger logger = Logger.getLogger(BankRepositoryImpl.class);
	private Map<Long, Bank> map = null;
	
	@Override
	public void add(Bank bank) {
		if(map == null){
			map = new HashMap<Long, Bank>();
		}
		if( !map.containsKey(bank.getId()) ){
			map.put(bank.getId(), bank);
		}else{
			logger.error("BankId alrady exist in repo. Please Assign unique id");
			try{
				throw new Exception("BankId duplication, need unique id");
			}catch(Exception e){
				e.printStackTrace();
				System.exit(1);	//end execution
			}
		}
	}

	@Override
	public void update(Bank bank) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void remove(Bank bank) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Bank getBankById(long bankId) {
		if(map != null){
			Bank bank = null;
			if(map.containsKey(bankId)){
				bank = map.get(bankId);
				return bank;
			}
		}
		logger.warn("Bank does not exist, returning null");
		return null;
	}
	
}
