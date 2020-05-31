package com.store.TaskService.Entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name = "employee_table")

public class EmployeeEntity {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private int emp_id;
	
	@Column
	private String emp_name;
	
	@Column
	private String emp_level;
	
	@Column
	private int emp_sal;
	
	@Column
	private String emp_hiredate;
		
	@Column
	private int dept_id;
		
	@Column
	private int user_id;

}
