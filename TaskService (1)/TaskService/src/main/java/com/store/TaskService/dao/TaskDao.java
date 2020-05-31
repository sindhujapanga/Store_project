package com.store.TaskService.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.store.TaskService.Entity.TaskEntity;

@Repository

public interface TaskDao extends JpaRepository<TaskEntity, Integer> {

}
