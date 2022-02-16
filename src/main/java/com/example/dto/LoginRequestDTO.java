package com.example.dto;

public class LoginRequestDTO {
	private Integer userId;
	private String password;
	public LoginRequestDTO(Integer userId, String password) {
		super();
		this.userId = userId;
		this.password = password;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "LoginRequestDTO [userId=" + userId + ", password=" + password + "]";
	}
	
}
