package com.justicehub.api.dto;

import java.util.UUID;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DefendantDTO {
	
	@NotNull(message = "Name cannot be null")
    private String name;
	
	@NotNull(message = "CPF cannot be null")
	@Size(min = 11, max = 11, message = "CPF must be 11 characters")
    private String cpf;   
	
	@NotNull(message = "Legal Case ID cannot be null")
    private UUID legalCaseId;

}
