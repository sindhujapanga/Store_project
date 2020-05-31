package com.store.ManagerService.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.store.ManagerService.entity.DepartmentEntity;

@Repository

public interface DepartmentDao extends JpaRepository<DepartmentEntity, Integer> {

}
