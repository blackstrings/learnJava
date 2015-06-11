package com.xai.patterns.domain.service;

import com.xai.patterns.domain.dao.EmployeeDAO;
import com.xai.patterns.domain.dao.EmployeeDAOImpl;
import com.xai.patterns.domain.domain.Employee;

/**
 * This is one of the many service for the domain. 
 * It handles business logic.
 * Services tells you almost nothing about what the object actually does.
 * Services should not be used to perform CRUD operations.
 * DAO or Repositories should be the ones performing the CRUD operations.
 *
 */
public class EmployeeRegistrationService extends RegistrationService {
	
	//services should reference a dao, and tell it to perform CRUD operations
	//services should not perform CRUD directly to databases
	private EmployeeDAO empDao;
	
	/**
	 * If we are passing in a parameter to this service, we absolutely mean
	 * this class depends on the incoming parameter, in this case a DAO
	 * @param empDao
	 */
	public EmployeeRegistrationService(EmployeeDAO empDao){
		//inject the dependency for CRUD operation
		this.empDao = empDao;
	}
	
	@Override
	public <K> boolean unregister(K employee) {
		Employee emp = (Employee) employee;
		return empDao.delete(emp.getId());
	}

	@Override
	public <K> boolean register(K employee) {
		Employee emp = (Employee) employee;
		return empDao.add(emp);
	}

	public Employee get(int id) {
		return empDao.get(id);
	}
	
	public boolean delete(int id){
		return empDao.delete(id);
	}


}
