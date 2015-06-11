package com.xai.patterns.domain.service;

import com.xai.patterns.domain.dao.EmployeeDAOImpl;

public class ServiceFactory {
	
	public enum Service{
		EMPLOYEE_REGISTRATION;
	}
	
	/**
	 * Not working at the moment
	 * @param service
	 * @return
	 */
	@Deprecated
	public static DomainService getService(Service service){
		if(service.equals(Service.EMPLOYEE_REGISTRATION.name())){
			//not the best way to inject dao but for test purpose we inject it here
			return new EmployeeRegistrationService(new EmployeeDAOImpl());
		}
		
		return null;
	}
	
	public static DomainService getEmpRegService(){
		return new EmployeeRegistrationService(new EmployeeDAOImpl());
	}
}
