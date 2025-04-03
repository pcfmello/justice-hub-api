package com.justicehub.api.services;

import java.util.List;
import java.util.UUID;

import com.justicehub.api.interfaces.ILegalCaseService;
import com.justicehub.api.models.Defendant;
import com.justicehub.api.models.LegalCase;

public class LegalCaseService implements ILegalCaseService {

	@Override
	public List<LegalCase> saveList(List<String> numbers) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<String> findAll() {
		// TODO Auto-generated method stub
		return null;
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
