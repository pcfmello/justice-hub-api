package com.justicehub.api.services.interfaces;

import com.justicehub.api.dto.DefendantDTO;
import com.justicehub.api.models.Defendant;

public interface IDefendantService {
	Defendant save(DefendantDTO dto);
}
