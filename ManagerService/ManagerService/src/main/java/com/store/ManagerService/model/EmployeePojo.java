package com.store.ManagerService.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;



@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class EmployeePojo {
	
	private int empId;
	private String empName;
	private String empLevel;
	private int empSal;
	private String empHiredate;
	DepartmentPojo dept;
	UserPojo user;
	
	
	
}
