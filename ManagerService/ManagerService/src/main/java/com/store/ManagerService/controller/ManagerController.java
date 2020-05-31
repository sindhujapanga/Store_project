package com.store.ManagerService.controller;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.store.ManagerService.model.EmployeePojo;
import com.store.ManagerService.model.TaskEmployeePojo;
import com.store.ManagerService.model.TaskPojo;
import com.store.ManagerService.service.ManagerService;




@CrossOrigin
@RestController
@RequestMapping("store")

public class ManagerController {
	
	static Logger LOG = LoggerFactory.getLogger(ManagerController.class.getClass());
	
	@Autowired
	ManagerService managerService;
	
	@PostMapping("/employee")
	public boolean addEmployee(@RequestBody EmployeePojo empPojo)
	{
		LOG.info("Entered managercontoller add employee");
		LOG.info("Exited managercontoller add employee");
		return managerService.addEmployee(empPojo);
		
	}
	
	@DeleteMapping("/employee/{empId}")
	public  Object deleteEmployee(@PathVariable("empId") int empId)
	{
		LOG.info("Entered managercontoller delete employee");
		LOG.info("Exited managercontoller delete employee");
		return managerService.deleteEmployee(empId);
	}
	@PutMapping("/employee")
	EmployeePojo updateEmployee(@RequestBody EmployeePojo empPojo) {
		
		LOG.info("Entered managercontoller update employee");
		LOG.info("Exited managercontoller update employee");
		
		return managerService.updateEmployee(empPojo);
	}
	@GetMapping("/employee/all")
	List<EmployeePojo> getAllEmployees(){
		
		LOG.info("Entered managercontoller getall employees");
		LOG.info("Exited managercontoller getall employees");
		
		return managerService.getAllEmployees();	
	}
	@Test
	@GetMapping("/employee/{empId}")
	EmployeePojo getEmployee(@PathVariable("empId") int empId)
	{
		LOG.info("Entered managercontoller get one employee");
		LOG.info("Exited managercontoller get one employee");
		return managerService.getEmployee(empId);
	}

	  @GetMapping("/task/{task_id}") 
	  @HystrixCommand(fallbackMethod = "getFallbackTask")
	  TaskPojo getTask(@PathVariable("task_id") int task_id)
	  {
		  RestTemplate restTemplate = new RestTemplate(); 
	   TaskPojo taskPojo = restTemplate.getForObject( "http://localhost:8083/TaskService/store/task/"+task_id, TaskPojo.class);
	  	  return taskPojo;
	  }
	  TaskPojo getFallbackTask(@PathVariable("task_id") int task_id)
	  {
		  return new TaskPojo(0,"serverdown",false);
	  }
	  
	  @GetMapping("/taskemp/{task_emp_id}") 
	 TaskEmployeePojo getTaskEmp(@PathVariable("task_emp_id") int taskempId)
	 {
		 RestTemplate restTemplate = new RestTemplate();
		 TaskEmployeePojo taskempPojo=restTemplate.getForObject("http://localhost:8083/TaskService/store/taskemp/"+taskempId, TaskEmployeePojo.class);
		 return taskempPojo;
	 }
	  
}
	  
	  

