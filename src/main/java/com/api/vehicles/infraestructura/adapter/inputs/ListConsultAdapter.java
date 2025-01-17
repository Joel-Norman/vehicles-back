package com.api.vehicles.infraestructura.adapter.inputs;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.vehicles.aplication.ports.inputs.ListConsultPort;
import com.api.vehicles.aplication.ports.outputs.ListConsultPersistencePort;
import com.api.vehicles.domain.Consult;
import com.api.vehicles.domain.ListConsult;
@Service
public class ListConsultAdapter implements ListConsultPort{

	@Autowired
	ListConsultPersistencePort portConsult;
	@Override
	public List<Consult> listConsult(String username) {
		// TODO Auto-generated method stub
		return portConsult.listConsultPersistence(username);
	}
	@Override
	public List<Consult> listConsultPendient(String status) {
		return portConsult.listConsultPendientPersistence(status);
	}
	@Override
	public List<ListConsult> listConsultPayments(Date startDate, Date endDate) {
		return portConsult.listConsultPaymentsPersistence(startDate, endDate);
	}

}
