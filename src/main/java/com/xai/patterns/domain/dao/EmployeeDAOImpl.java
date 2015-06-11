package com.xai.patterns.domain.dao;

import java.util.ArrayList;
import java.util.List;

import com.xai.patterns.domain.domain.Employee;

public class EmployeeDAOImpl implements EmployeeDAO {

	List<Employee> employees = new ArrayList<Employee>();
	
	@Override
	public <K> Employee get(K id) {
		Integer ID = (Integer) id;
		for(Employee emp : employees){
			if(emp.getId() == ID){
				return new Employee(emp);
			}
		}
		return null;
	}

	@Override
	public boolean delete(Integer id) {
		int index = 0;
		for(Employee emp : employees){
			if(emp.getId() == id){
				employees.remove(index);
				return true;
			}
			index++;
		}
		return false;
	}

	@Override
	public boolean update(Employee employee) {
		for(Employee emp : employees){
			if(employee.getId() == emp.getId()){
				emp = employee;
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean add(Employee employee) {
		for(Employee emp : employees){
			if(employee.getId() == emp.getId()){
				return false;
			}
		}
		employees.add(employee);
		return true;
	}

}
