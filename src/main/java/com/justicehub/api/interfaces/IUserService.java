package com.justicehub.api.interfaces;

import com.justicehub.api.models.User;

public interface IUserService {
	User save(User user);
	User findByEmail(String email);
}
