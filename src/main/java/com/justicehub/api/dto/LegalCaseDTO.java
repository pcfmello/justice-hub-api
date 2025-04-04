package com.justicehub.api.dto;

import java.util.List;
import java.util.UUID;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LegalCaseDTO {
    
    @NotNull(message = "Case number cannot be null")
    private List<String> caseNumbers;

    @NotNull(message = "User id cannot be null")
    private UUID userId;
}