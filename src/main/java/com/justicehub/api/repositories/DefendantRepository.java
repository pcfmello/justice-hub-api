package com.justicehub.api.repositories;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.justicehub.api.models.Defendant;

@Repository
public interface DefendantRepository extends JpaRepository<Defendant, UUID> {
	Optional<Defendant> findByCpfAndLegalCaseId(String cpf, UUID legalCaseId);
}