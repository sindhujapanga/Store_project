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
public class TaskPojo {	
	
	private int task_id;	
	private String task_action;	
	private boolean task_status;
	
	
}