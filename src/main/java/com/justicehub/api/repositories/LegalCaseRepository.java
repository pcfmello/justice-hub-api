package com.justicehub.api.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.justicehub.api.models.LegalCase;
import com.justicehub.api.models.User;

@Repository
public interface LegalCaseRepository extends JpaRepository<LegalCase, UUID> {
    
    
}