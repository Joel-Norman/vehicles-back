package com.api.vehicles.aplication.ports.outputs;


import com.api.vehicles.domain.Register;

public interface UserPersistencePort {
	public Register saveUser(Register user);
}
