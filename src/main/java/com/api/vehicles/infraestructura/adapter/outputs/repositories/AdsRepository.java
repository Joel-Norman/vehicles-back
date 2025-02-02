package com.api.vehicles.infraestructura.adapter.outputs.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.vehicles.infraestructura.adapter.outputs.entities.AdsEntity;

@Repository
public interface AdsRepository extends JpaRepository<AdsEntity, Long>{

}
