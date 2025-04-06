package com.justicehub.api.services.impl;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.justicehub.api.dto.UserDTO;
import com.justicehub.api.exceptions.UserAlreadyExistsException;
import com.justicehub.api.models.User;
import com.justicehub.api.repositories.UserRepository;
import com.justicehub.api.services.interfaces.IUserService;

@Service
public class UserService implements IUserService {
	@Autowired
    private ModelMapper modelMapper;
	
	@Autowired
	private UserRepository userRepository;
	
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
