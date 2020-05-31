package com.store.ManagerService.entity;

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
@Table(name = "user_table")

public class UserEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id")
	private int userId;
	
	@Column(name = "user_name")
	private String userName;
	
	@Column(name = "user_username")
	private String userUsername;
	
	@Column(name = "user_password")
	private String userPassword;
	
	@Column(name = "user_role")
	private String userRole;

	

	

}
