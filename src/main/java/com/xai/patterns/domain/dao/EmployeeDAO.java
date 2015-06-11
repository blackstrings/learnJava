package com.xai.patterns.domain.dao;

import com.xai.patterns.domain.domain.Employee;

public interface EmployeeDAO {
	public <K> Employee get(K id);
	public boolean delete(Integer id);
	public boolean update(Employee employee);
	public boolean add(Employee employee);
}
