package com.example.controller;

import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.dto.LoginRequestDTO;
import com.example.dto.RegisterUserDTO;
import com.example.dto.Response;
import com.example.entity.Users;
import com.example.exception.UserNotFoundException;
import com.example.service.RegisterUserService;

@RestController
@CrossOrigin
public class RegisterUserController {

	@Autowired
	private RegisterUserService service;
	
	
	@PostMapping(path = "/login", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> performLogin(@RequestBody LoginRequestDTO loginRequestDTO) {
		try {
			Response response = service.performLogin(loginRequestDTO);
			return ResponseEntity.status(HttpStatus.OK).body(response);
		} catch (UserNotFoundException e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new Response(400, e.getMessage()));
		}
	}
	@GetMapping(path = "/logout")
	public ResponseEntity<Object> performLogout() {
		return ResponseEntity.status(HttpStatus.OK).body(new Response(200,"Logged out successfully!"));
	}
	
	@PostMapping(path = "/register", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> registerUser(@RequestBody RegisterUserDTO registerRequestDTO) throws ParseException {
		try {
			Users user = service.registerUser(registerRequestDTO);

			return ResponseEntity.status(HttpStatus.OK).body(user);
		} catch (UserNotFoundException p) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new Response(400, p.getMessage()));
		}
		
	}
	
}
