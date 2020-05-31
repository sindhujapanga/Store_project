package com.store.TaskService.model;

import java.util.Date;

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
	
	private int emp_id;
	private String emp_name;
	private String emp_level;
	private int emp_sal;
	private String emp_hiredate;
	private int dept_id;
	private int user_id;
	
	
	

}
