package com.store.ManagerService.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.store.ManagerService.entity.UserEntity;


@Repository
public interface UserDao extends JpaRepository<UserEntity, Integer>
{
	
}
