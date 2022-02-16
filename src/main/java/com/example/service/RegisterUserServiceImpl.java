package com.example.service;

import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dto.LoginRequestDTO;
import com.example.dto.RegisterUserDTO;
import com.example.dto.Response;
import com.example.entity.Users;
import com.example.exception.UserNotFoundException;
import com.example.repository.RegisterUser;

@Service
public class RegisterUserServiceImpl implements RegisterUserService{

	@Autowired
	private RegisterUser userRepo;

	@Override
	public Response performLogin(LoginRequestDTO loginRequestDTO) throws UserNotFoundException {
		
		if(Objects.isNull(loginRequestDTO.getUserId()) || Objects.isNull(loginRequestDTO.getPassword())) {
			throw new UserNotFoundException("User Id Or password should not be empty");
		}
		Optional<Users> customerOptional = userRepo.findById(loginRequestDTO.getUserId());
		
		
		if(!customerOptional.isPresent()){
			throw new UserNotFoundException("User not found!");
		}
		
		Users user = customerOptional.get();
		if (!user.getPassword().equals(loginRequestDTO.getPassword())) {
			throw new UserNotFoundException("Entered password is wrong!");
		}
		return new  Response(200,"Loggin successful!");
	}

	@Override
	public Users registerUser(RegisterUserDTO registerRequestDTO) throws UserNotFoundException{
		
	    Users user = null;
		user = new Users(registerRequestDTO.getUserId(),registerRequestDTO.getFirstName(), registerRequestDTO.getLastName()
				, registerRequestDTO.getDob(), registerRequestDTO.getAddress(),registerRequestDTO.getContactNum(),registerRequestDTO.getEmail()
				, registerRequestDTO.getPassword());
		user = userRepo.save(user);
	    
		return user;
	}

}
