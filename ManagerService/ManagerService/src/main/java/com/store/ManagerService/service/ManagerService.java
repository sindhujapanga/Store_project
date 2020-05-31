package com.store.ManagerService.service;



import java.util.List;

import com.store.ManagerService.model.EmployeePojo;




public interface ManagerService {
	
	boolean addEmployee(EmployeePojo empPojo);
	
	public Object deleteEmployee(Integer empId);
	
	EmployeePojo updateEmployee( EmployeePojo empPojo);

	List<EmployeePojo> getAllEmployees();
	
	EmployeePojo getEmployee(int empId);
	
	

}
