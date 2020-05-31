package com.store.TaskService.model;

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

public class TaskEmployeePojo {
	
	private int task_emp_id;
	private boolean task_status;
	TaskPojo task;
	EmployeePojo emp;
	
	
}
