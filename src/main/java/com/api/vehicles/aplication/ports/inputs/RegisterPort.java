package com.api.vehicles.aplication.ports.inputs;


import com.api.vehicles.domain.Register;

public interface RegisterPort {
	public Register registerUser(Register register);
}
