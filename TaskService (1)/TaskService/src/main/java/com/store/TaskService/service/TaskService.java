package com.store.TaskService.service;

import java.util.List;

import com.store.TaskService.model.TaskEmployeePojo;
import com.store.TaskService.model.TaskPojo;

public interface TaskService {
	
	TaskPojo addTask(TaskPojo taskPojo);
	
	TaskPojo getTask(int task_id);
	

	List<TaskPojo> getAllTasks();

	TaskEmployeePojo addTaskToEmp(TaskEmployeePojo taskempPojo);

	TaskEmployeePojo getTaskEmp(int taskempId);

	

}



