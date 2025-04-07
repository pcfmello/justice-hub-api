package com.justicehub.api.services.impl;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.justicehub.api.dto.UserDTO;
import com.justicehub.api.exceptions.UserAlreadyExistsException;
import com.justicehub.api.models.User;
import com.justicehub.api.repositories.UserRepository;
import com.justicehub.api.services.interfaces.IUserService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService implements IUserService {
	private final UserRepository userRepository;
	private final ModelMapper modelMapper;
	
	@Transactional
	public User save(UserDTO userDTO) {
		if (userRepository.existsByEmail(userDTO.getEmail())) {
            throw new UserAlreadyExistsException(userDTO.getEmail());
        }
		
		User user = modelMapper.map(userDTO, User.class);
		return userRepository.save(user);
	}

	public User findByEmail(String email) {
	    Optional<User> userOptional = userRepository.findByEmail(email);
	    return userOptional.orElse(null);
	}
}
