package com.justicehub.api.services.interfaces;

import java.util.List;
import java.util.UUID;

import com.justicehub.api.dto.LegalCaseDTO;
import com.justicehub.api.models.Defendant;
import com.justicehub.api.models.LegalCase;

public interface ILegalCaseService {
	List<LegalCase> saveList(LegalCaseDTO legalCaseDTO);
	List<LegalCase> findByUserId(UUID userId);
	void delete(UUID id);
	
	// LegalCase findByNumber(String number);
	LegalCase addDefendantToLegalCase(LegalCase legalCase, Defendant defendant);
}
