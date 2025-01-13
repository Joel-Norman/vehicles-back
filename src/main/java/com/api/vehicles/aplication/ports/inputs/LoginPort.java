package com.api.vehicles.aplication.ports.inputs;


import com.api.vehicles.domain.Login;
import com.api.vehicles.domain.Session;

public interface LoginPort {
	public Session loginUser(Login login);
}
