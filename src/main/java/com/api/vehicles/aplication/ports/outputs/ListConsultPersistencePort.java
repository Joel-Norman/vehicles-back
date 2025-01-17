package com.api.vehicles.aplication.ports.outputs;

import java.util.Date;
import java.util.List;

import com.api.vehicles.domain.Consult;
import com.api.vehicles.domain.ListConsult;

public interface ListConsultPersistencePort {
	List<Consult> listConsultPersistence(String username);
	List<Consult> listConsultPendientPersistence(String username);
	List<ListConsult> listConsultPaymentsPersistence(Date init, Date end);
}
