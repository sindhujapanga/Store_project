package com.store.ManagerService.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.store.ManagerService.entity.EmployeeEntity;

@Repository

public interface EmployeeDao extends JpaRepository<EmployeeEntity, Integer> {

}
