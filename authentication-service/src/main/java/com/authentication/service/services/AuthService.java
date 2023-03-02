package com.authentication.service.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.authentication.service.entity.Auth;
import com.authentication.service.repository.AuthRepository;

@Service
public class AuthService {
	@Autowired
	private AuthRepository authRepository;
	
	public List<Auth> getAll(){
		return authRepository.findAll();
	}
	
	public Auth getAuthById(int Id) {
		return authRepository.findById(Id).orElse(null);
	}
	
	public Auth save(Auth auth) {
		Auth newAuth = authRepository.save(auth);
		return newAuth;
	}
}
