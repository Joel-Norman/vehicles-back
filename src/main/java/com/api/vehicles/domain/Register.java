package com.api.vehicles.domain;

public class Register {
	String email;
	String password;
	String repetPassword;
	public Register() {
		super();
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRepetPassword() {
		return repetPassword;
	}
	public void setRepetPassword(String repetPassword) {
		this.repetPassword = repetPassword;
	}
	
	
}
