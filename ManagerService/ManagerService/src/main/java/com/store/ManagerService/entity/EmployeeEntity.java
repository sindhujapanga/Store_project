package com.store.ManagerService.entity;


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
@Table(name = "employee_table")

public class EmployeeEntity {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "emp_id")
	private int empId;
	
	@Column(name = "emp_name")
	private String empName;
	
	@Column(name = "emp_level")
	private String empLevel;
	
	@Column(name = "emp_sal")
	private int empSal;
	
	@Column(name = "emp_hiredate")
	private String empHiredate;
	
	@ManyToOne
	@JoinColumn(name = "dept_id")
	private DepartmentEntity dept;
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	private UserEntity user;


	
	
	
}