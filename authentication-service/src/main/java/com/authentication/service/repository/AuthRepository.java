package com.authentication.service.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.authentication.service.entity.Auth;

public interface AuthRepository extends JpaRepository<Auth, Integer>{
	
}
