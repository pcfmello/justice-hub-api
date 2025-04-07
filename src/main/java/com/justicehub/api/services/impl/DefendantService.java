package com.justicehub.api.services.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import com.justicehub.api.dto.DefendantDTO;
import com.justicehub.api.models.Defendant;
import com.justicehub.api.models.LegalCase;
import com.justicehub.api.repositories.DefendantRepository;
import com.justicehub.api.repositories.LegalCaseRepository;
import com.justicehub.api.services.interfaces.IDefendantService;

@Service
public class DefendantService implements IDefendantService {
	
	@Autowired
	private LegalCaseRepository legalCaseRepository;
	
	@Autowired
	private DefendantRepository defendantRepository;

	@Transactional
	public Defendant save(DefendantDTO dto) {
	    LegalCase legalCase = legalCaseRepository.findByIdAndDeletedFalse(dto.getLegalCaseId())
	        .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Legal Case not found"));

	    Optional<Defendant> existingDefendant = defendantRepository.findByCpfAndLegalCaseId(dto.getCpf(), dto.getLegalCaseId());

	    if (existingDefendant.isPresent()) {
	        throw new ResponseStatusException(HttpStatus.CONFLICT, "There is already a defendant with this CPF in this case");
	    }

	    Defendant defendant = new Defendant();
	    defendant.setLegalCase(legalCase);
	    defendant.setName(dto.getName());
	    defendant.setCpf(dto.getCpf());

	    return defendantRepository.save(defendant);
	}

}
