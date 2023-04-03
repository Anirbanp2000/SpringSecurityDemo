package com.spring.security.test.SpringSecurityDemo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.security.test.SpringSecurityDemo.entity.User;


@RestController
@RequestMapping("/home")
public class HomeController {
	
	
    
	@PreAuthorize("hasRole('ADMIN')")
	@GetMapping("/admin")
	public ResponseEntity<String> adminUser(){
		return ResponseEntity.ok("Admin user logged in....");
	}
	
	@PreAuthorize("hasRole('NORMAL')")
	@GetMapping("/normal")
	public ResponseEntity<String> normalUser(){
		return ResponseEntity.ok("Normal user logged in....");
	}
	
	@GetMapping("/public")
	public ResponseEntity<String> publicUser(){
		return ResponseEntity.ok("Public user logged in....");
	}
	
//	@PostMapping("/register")
//    public String registration(@RequestBody User user) {
//		CustomUserDetailsService.registration(user);
//		return "added successfully...";
//	}	
//	
	
}


