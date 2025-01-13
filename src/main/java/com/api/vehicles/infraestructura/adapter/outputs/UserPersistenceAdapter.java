package com.api.vehicles.infraestructura.adapter.outputs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.api.vehicles.aplication.ports.outputs.UserPersistencePort;
import com.api.vehicles.domain.Register;
import com.api.vehicles.infraestructura.adapter.outputs.entities.User;
import com.api.vehicles.infraestructura.adapter.outputs.repositories.UserRespository;
@Service
public class UserPersistenceAdapter implements UserPersistencePort{
	@Autowired
	UserRespository userRepo;
	@Autowired
    PasswordEncoder passwordEncoder;
	@Override
	public Register saveUser(Register user) {
		try {
			User newUser=new User();
			newUser.setUsername(user.getEmail());
			newUser.setPassword(passwordEncoder.encode(user.getPassword()));
			newUser=userRepo.save(newUser);
			return user;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}

}
