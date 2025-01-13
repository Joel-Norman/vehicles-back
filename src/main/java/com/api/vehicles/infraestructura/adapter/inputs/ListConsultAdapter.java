package com.api.vehicles.infraestructura.adapter.inputs;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.vehicles.aplication.ports.inputs.ListConsultPort;
import com.api.vehicles.aplication.ports.outputs.ListConsultPersistencePort;
import com.api.vehicles.domain.Consult;
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

}
