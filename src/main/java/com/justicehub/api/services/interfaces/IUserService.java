package com.justicehub.api.services.interfaces;

import com.justicehub.api.dto.UserDTO;
import com.justicehub.api.models.User;

public interface IUserService {
	User save(UserDTO userDTO);
	User findByEmail(String email);
}
