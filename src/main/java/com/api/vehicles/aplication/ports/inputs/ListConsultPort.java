package com.api.vehicles.aplication.ports.inputs;

import java.util.Date;
import java.util.List;

import com.api.vehicles.domain.Consult;
import com.api.vehicles.domain.ListConsult;

public interface ListConsultPort {
	List<Consult> listConsult(String username);
	List<Consult> listConsultPendient(String status);
	List<ListConsult> listConsultPayments(Date startDate, Date endDate);
}
