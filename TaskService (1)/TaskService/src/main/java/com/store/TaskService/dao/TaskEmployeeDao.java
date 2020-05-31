package com.store.TaskService.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.store.TaskService.Entity.TaskEmployeeEntity;


@Repository

public interface TaskEmployeeDao  extends JpaRepository<TaskEmployeeEntity, Integer>{

}
