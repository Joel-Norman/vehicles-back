package com.api.vehicles.infraestructura.adapter.inputs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.vehicles.aplication.ports.inputs.RegisterPort;
import com.api.vehicles.aplication.ports.outputs.UserPersistencePort;
import com.api.vehicles.domain.Register;
@Service
public class RegisterAdapter implements RegisterPort {
	@Autowired
	UserPersistencePort userPresistence;
	@Override
	public Register registerUser(Register register) {
		return userPresistence.saveUser(register);
	}

}
