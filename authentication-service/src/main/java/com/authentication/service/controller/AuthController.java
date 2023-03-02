package com.authentication.service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.authentication.service.entity.Auth;
import com.authentication.service.services.AuthService;

@RestController
@RequestMapping("/auth")
public class AuthController {
	
	@Autowired
	private AuthService authService;
	
	@GetMapping
	public ResponseEntity<List<Auth>> listAuth(){
		List<Auth> auth = authService.getAll();
		if(auth.isEmpty()) {
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.ok(auth);
	}
	@GetMapping("/{id}")
	public ResponseEntity<Auth> obtainAuth(@PathVariable("id") int id){
		Auth auth = authService.getAuthById(id);
		if(auth == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(auth);
	}
	
	@PostMapping
	public ResponseEntity<Auth> saveAuth(@RequestBody Auth auth){
		Auth newAuth = authService.save(auth);
		return ResponseEntity.ok(newAuth);
	}
}
