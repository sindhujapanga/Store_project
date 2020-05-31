package com.store.TaskService.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Data


@Entity
@Table(name = "task_emptable")

public class TaskEmployeeEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private int task_emp_id;
	
	@Column
	private boolean task_status;
		
	@ManyToOne	
	@JoinColumn(name = "task_id")
	TaskEntity task;
	
	@ManyToOne
	@JoinColumn(name = "emp_id")
	EmployeeEntity emp;

	

}
