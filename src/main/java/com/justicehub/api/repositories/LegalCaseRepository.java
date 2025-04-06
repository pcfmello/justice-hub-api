package com.justicehub.api.repositories;

import java.util.List;
import java.util.UUID;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.justicehub.api.models.LegalCase;

@Repository
public interface LegalCaseRepository extends JpaRepository<LegalCase, UUID> {
	List<LegalCase> findByNumberIn(List<String> numbers);
    List<LegalCase> findByUserIdAndDeletedFalse(UUID userId);
    Optional<LegalCase> findByIdAndDeletedFalse(UUID id);
}