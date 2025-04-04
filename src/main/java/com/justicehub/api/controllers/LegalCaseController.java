package com.justicehub.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.justicehub.api.dto.LegalCaseDTO;
import com.justicehub.api.models.LegalCase;
import com.justicehub.api.services.impl.LegalCaseService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/legal-cases")
public class LegalCaseController {
	
	@Autowired
    private LegalCaseService legalCaseService;
	
	@PostMapping
    public ResponseEntity<?> create(@RequestBody @Valid LegalCaseDTO legalCaseDTO) {	
		try {
			List<LegalCase> savedLegalCases = legalCaseService.saveList(legalCaseDTO);
			return ResponseEntity.status(HttpStatus.CREATED).body(savedLegalCases);
		} catch (RuntimeException e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}

}
