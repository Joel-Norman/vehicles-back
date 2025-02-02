package com.api.vehicles.domain;

public class RequestLogin {
	String apiuser;
    String password;
    
    
	public RequestLogin(String apiuser, String password) {
		super();
		this.apiuser = apiuser;
		this.password = password;
	}
	public String getApiuser() {
		return apiuser;
	}
	public void setApiuser(String apiuser) {
		this.apiuser = apiuser;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
    
    
}
