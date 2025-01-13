package com.api.vehicles.infraestructura.adapter.outputs.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.vehicles.infraestructura.adapter.outputs.entities.User;
@Repository
public interface UserRespository extends JpaRepository<User, Long>{
	public User findByUsername(String username);
}
