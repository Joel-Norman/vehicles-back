package com.api.vehicles.aplication.ports.inputs;

import java.util.List;

import com.api.vehicles.domain.Consult;

public interface ListConsultPort {
	List<Consult> listConsult(String username);
	List<Consult> listConsultPendient(String status);
}
