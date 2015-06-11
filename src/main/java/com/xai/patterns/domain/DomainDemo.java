package com.xai.patterns.domain;

import com.xai.patterns.domain.domain.Employee;
import com.xai.patterns.domain.service.EmployeeRegistrationService;
import com.xai.patterns.domain.service.ServiceFactory;

/**
 * <p>
 * Domains are pretty much the entities that are related to your business.
 * They only hold data or are simply POJO
 * DAO are the repositories that do CRUD modifications to Domain objects
 * </p>
 * @see 
 * <a href="https://vrtoonjava.wordpress.com/2012/06/17/part-1-designing-the-domain-model-and-the-service-layer/">
 * tutorial on domain and services</a>
 *
 */
public class DomainDemo {

	public static void main(String [] args){
		
		EmployeeRegistrationService s = (EmployeeRegistrationService) ServiceFactory.getEmpRegService();
		
		if(s.register(new Employee("Tom", 111)))
			System.out.println("register1 succeeded");
		
		if(s.register(new Employee("Bill", 112)))
			System.out.println("register2 succeeded");
		
		System.out.println(s.get(112));
		
		if(s.delete(112)){
			System.out.println("delete id 112 success");
		}else{
			System.out.println("delete id 112 failed");
		}
		
		System.out.println(s.get(112));
		
		
	}
	
}
