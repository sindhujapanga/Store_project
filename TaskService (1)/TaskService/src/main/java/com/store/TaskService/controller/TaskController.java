package com.store.TaskService.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.store.TaskService.model.TaskEmployeePojo;
import com.store.TaskService.model.TaskPojo;
import com.store.TaskService.service.TaskService;

@CrossOrigin
@RestController
@RequestMapping("store")

public class TaskController {
	
	
	@Autowired
	TaskService taskService;
	
	@PostMapping("task")
	TaskPojo addTask(@RequestBody TaskPojo taskPojo)
	{
				return taskService.addTask(taskPojo);
	}
	
	@GetMapping("task/{task_id}")
	TaskPojo getTask(@PathVariable("task_id") int task_id) {
		return taskService.getTask(task_id);
	}
	
	@PostMapping("tasktoemp")
	TaskEmployeePojo addTaskToEmp(@RequestBody TaskEmployeePojo taskempPojo )
	{
				return taskService.addTaskToEmp(taskempPojo);
	}
	
	@GetMapping("taskemp/{task_emp_id}")
	TaskEmployeePojo getTaskEmp(@PathVariable("task_emp_id") int taskempId) {
		return taskService.getTaskEmp(taskempId);
	}
	
	@GetMapping("/task/all")
	List<TaskPojo> getAllTasks(){
		
		return taskService.getAllTasks();	
	}
	
}

