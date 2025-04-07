package com.justicehub.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.justicehub.api.dto.DefendantDTO;
import com.justicehub.api.services.impl.DefendantService;

@RestController
@RequestMapping("/defendants")
public class DefendantController {
	
	@Autowired
    private DefendantService defendantService;
	
	@PostMapping
	public ResponseEntity<Void> save(@RequestBody DefendantDTO dto) {
		defendantService.save(dto);
	    return ResponseEntity.status(HttpStatus.CREATED).build();
	}
}
