package com.example.service;

import java.text.ParseException;

import com.example.dto.LoginRequestDTO;
import com.example.dto.RegisterUserDTO;
import com.example.dto.Response;
import com.example.entity.Users;
import com.example.exception.UserNotFoundException;


public interface RegisterUserService {
	public Response performLogin(LoginRequestDTO loginRequestDTO) throws UserNotFoundException;

	public Users registerUser(RegisterUserDTO registerRequestDTO) throws UserNotFoundException;
}
