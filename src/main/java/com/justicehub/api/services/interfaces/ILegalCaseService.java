package com.justicehub.api.services.interfaces;

import java.util.List;
import java.util.UUID;

import com.justicehub.api.models.Defendant;
import com.justicehub.api.models.LegalCase;

public interface ILegalCaseService {
	List<LegalCase> saveList(List<String> numbers);
	List<String> findAll();
	LegalCase findByNumber(String number);
	void delete(UUID id);
	LegalCase addDefendantToLegalCase(LegalCase legalCase, Defendant defendant);
}
