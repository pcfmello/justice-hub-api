package com.justicehub.api.dto;

import java.util.List;
import java.util.UUID;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LegalCaseDTO {
    
    @NotNull(message = "Case number cannot be null")
    private List<String> caseNumbers;

    @NotNull(message = "User id cannot be null")
    private UUID userId;
}