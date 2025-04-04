package com.justicehub.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.justicehub.api.dto.UserDTO;
import com.justicehub.api.models.User;
import com.justicehub.api.services.impl.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/users")
public class UserController {
	
	@Autowired
    private UserService userService;

	@PostMapping
    public ResponseEntity<User> create(@RequestBody @Valid UserDTO userDTO) {		
        User createdUser = userService.save(userDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdUser);
    }
	
	@GetMapping("/email/{email}")
	public ResponseEntity<User> getUserByEmail(@PathVariable String email) {
	    User user = userService.findByEmail(email);
	    
	    if (user == null) {  
	        return ResponseEntity.notFound().build(); 
	    }

	    return ResponseEntity.ok(user);
	}
}
