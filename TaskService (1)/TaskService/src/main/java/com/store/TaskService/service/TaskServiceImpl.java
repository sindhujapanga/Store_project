package com.store.TaskService.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.store.TaskService.Entity.EmployeeEntity;
import com.store.TaskService.Entity.TaskEmployeeEntity;
import com.store.TaskService.Entity.TaskEntity;
import com.store.TaskService.dao.TaskDao;
import com.store.TaskService.dao.TaskEmployeeDao;
import com.store.TaskService.model.EmployeePojo;
import com.store.TaskService.model.TaskEmployeePojo;
import com.store.TaskService.model.TaskPojo;



@Service

public class TaskServiceImpl implements TaskService {
	
	@Autowired
	TaskDao taskDao;
	
	@Autowired
	TaskEmployeeDao taskEmployeeDao; 
	

	@Override
	//@Transactional
	public TaskPojo addTask(TaskPojo taskPojo) {
		
		TaskEntity taskEntity = new TaskEntity(taskPojo.getTask_id(),taskPojo.getTask_action(),taskPojo.isTask_status());
		
		taskEntity=taskDao.save(taskEntity);
		taskPojo.setTask_id(taskEntity.getTask_id());
		return taskPojo;
			
	}


	@Override
	public TaskPojo getTask(int task_id) {
		// TODO Auto-generated method stub

		TaskPojo taskPojo=null;
		Optional result = taskDao.findById(task_id);
		if(result.isPresent())
		{
			TaskEntity taskEntity=(TaskEntity) result.get();
			 taskPojo=new TaskPojo(taskEntity.getTask_id(),taskEntity.getTask_action(),taskEntity.isTask_status());
			
		}
		return taskPojo;
	}

	@Override
	public TaskEmployeePojo addTaskToEmp(TaskEmployeePojo taskempPojo) {
		//TaskPojo taskPojo=null;
		if(!taskempPojo.isTask_status())
        {
		 TaskPojo taskPojo = taskempPojo.getTask();
		 TaskEntity taskEntity = new TaskEntity();
		 taskEntity.setTask_id(taskPojo.getTask_id());
		 taskPojo.setTask_status(true);
			//taskPojo.isTask_status();
		EmployeePojo empPojo = taskempPojo.getEmp();

		EmployeeEntity empEntity = new EmployeeEntity();
		empEntity.setEmp_id(empPojo.getEmp_id());
		taskempPojo.setTask_status(true);
		//taskempPojo.getTask_status();
		TaskEmployeeEntity taskempEntity = new TaskEmployeeEntity(taskempPojo.getTask_emp_id(),taskempPojo.isTask_status(),taskEntity,empEntity);
		
		taskempEntity=taskEmployeeDao.save(taskempEntity);
		taskempPojo.setTask_emp_id(taskempEntity.getTask_emp_id());
       
		return taskempPojo;
        }
       
		return null;
	}

	@Override
	public TaskEmployeePojo getTaskEmp(int taskempId) {
		// TODO Auto-generated method stub
		
		TaskEmployeePojo taskempPojo=null;
		Optional result = taskEmployeeDao.findById(taskempId);
		if(result.isPresent())
		{
			TaskEmployeeEntity taskempEntity=(TaskEmployeeEntity) result.get();
			TaskEntity taskEntity = taskempEntity.getTask();

			EmployeeEntity empEntity=taskempEntity.getEmp();
			EmployeePojo empPojo=new EmployeePojo(empEntity.getEmp_id(),empEntity.getEmp_name(),empEntity.getEmp_level(),
					empEntity.getEmp_sal(),empEntity.getEmp_hiredate(),empEntity.getDept_id(),empEntity.getUser_id());
			TaskPojo taskPojo = new TaskPojo(taskEntity.getTask_id(),taskEntity.getTask_action(),taskEntity.isTask_status());
			 taskempPojo=new TaskEmployeePojo(taskempEntity.getTask_emp_id(),taskempEntity.isTask_status(),taskPojo,empPojo);
			
		}
		return taskempPojo;
	}
	
	
	@Override
	public List<TaskPojo> getAllTasks() {
		 
		List<TaskPojo> allTaskPojo = new ArrayList<TaskPojo>();
		Iterable<TaskEntity> allTaskEntity = taskDao.findAll();
		Iterator<TaskEntity> itr = allTaskEntity.iterator();
		while (itr.hasNext()) 
		{
			TaskEntity taskEntity = (TaskEntity) itr.next();
			
		
			 TaskPojo taskPojo=new TaskPojo(taskEntity.getTask_id(),taskEntity.getTask_action(),taskEntity.isTask_status());
			 allTaskPojo.add(taskPojo);
		}
		
		return allTaskPojo;
	}


}
