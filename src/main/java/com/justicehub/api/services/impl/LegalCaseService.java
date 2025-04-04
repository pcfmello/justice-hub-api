package com.justicehub.api.services.impl;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.justicehub.api.dto.LegalCaseDTO;
import com.justicehub.api.models.Defendant;
import com.justicehub.api.models.LegalCase;
import com.justicehub.api.models.User;
import com.justicehub.api.repositories.LegalCaseRepository;
import com.justicehub.api.repositories.UserRepository;
import com.justicehub.api.services.interfaces.ILegalCaseService;

@Service
public class LegalCaseService implements ILegalCaseService {
	
	@Autowired
    private LegalCaseRepository legalCaseRepository;
	
	@Autowired
    private UserRepository userRepository;


	public List<LegalCase> saveList(LegalCaseDTO legalCaseDTO) {
	    
	    List<String> existingNumbers = legalCaseRepository.findByNumberIn(legalCaseDTO.getCaseNumbers())
	            .stream()
	            .map(LegalCase::getNumber)
	            .collect(Collectors.toList());
	    
	    if (!existingNumbers.isEmpty()) {
	        throw new RuntimeException("Os seguintes números de processo já foram cadastrados: " + existingNumbers);
	    }
	    
	    User user = userRepository.findById(legalCaseDTO.getUserId())
	            .orElseThrow(() -> new RuntimeException("Usuário com ID " + legalCaseDTO.getUserId() + " não encontrado."));
	
	    List<LegalCase> newCases = legalCaseDTO.getCaseNumbers().stream()
	            .filter(number -> !existingNumbers.contains(number))
	            .map(number -> {
	                LegalCase legalCase = new LegalCase();
	                legalCase.setNumber(number);
	                legalCase.setUser(user);
	                return legalCase;
	            })
	            .collect(Collectors.toList());
	
	    return legalCaseRepository.saveAll(newCases);
	}
	
	public List<LegalCase> findByUserId(UUID userId) {
	    return legalCaseRepository.findByUserId(userId);
	}

	@Override
	public LegalCase findByNumber(String number) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(UUID id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public LegalCase addDefendantToLegalCase(LegalCase legalCase, Defendant defendant) {
		// TODO Auto-generated method stub
		return null;
	}
}
