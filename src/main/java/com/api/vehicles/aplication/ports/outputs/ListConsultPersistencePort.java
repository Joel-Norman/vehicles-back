package com.api.vehicles.aplication.ports.outputs;

import java.util.List;

import com.api.vehicles.domain.Consult;

public interface ListConsultPersistencePort {
	List<Consult> listConsultPersistence(String username);
	List<Consult> listConsultPendientPersistence(String username);
}
