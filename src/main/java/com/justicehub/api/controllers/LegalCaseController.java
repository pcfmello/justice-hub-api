package com.justicehub.api.controllers;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
    public ResponseEntity<?> save(@RequestBody @Valid LegalCaseDTO legalCaseDTO) {	
		try {
			List<LegalCase> savedLegalCases = legalCaseService.saveList(legalCaseDTO);
			return ResponseEntity.status(HttpStatus.CREATED).body(savedLegalCases);
		} catch (RuntimeException e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}
	
	@GetMapping("/user/{userId}")
	public ResponseEntity<List<LegalCase>> getByUserId(@PathVariable UUID userId) {
	    List<LegalCase> cases = legalCaseService.findByUserId(userId);
	    return ResponseEntity.ok(cases);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable UUID id) {
	    legalCaseService.delete(id);
	    return ResponseEntity.noContent().build();
	}

}
