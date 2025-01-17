package com.api.vehicles.infraestructura.adapter.outputs.repositories;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.vehicles.infraestructura.adapter.outputs.entities.ConsultEntity;

@Repository
public interface ConsultEntityRepository extends JpaRepository<ConsultEntity, Long>{
	public List<ConsultEntity> findByUserUsername(String userman);
	public List<ConsultEntity> findByStatus(String status);
	public List<ConsultEntity> findByInitDateBetween(Date startDate, Date endDate);
}
