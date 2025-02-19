package com.api.vehicles.infraestructura.adapter.inputs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.vehicles.aplication.ports.inputs.GenerarConsultaPort;
import com.api.vehicles.aplication.ports.outputs.GenerateConsultPersistencePort;
import com.api.vehicles.domain.GenerarConsulta;
import com.api.vehicles.domain.Response;
@Service
public class GenerarConsultaAdapter implements GenerarConsultaPort {
	@Autowired
	GenerateConsultPersistencePort consultPresistence;
	@Override
	public GenerarConsulta generateCOnsult(GenerarConsulta consult) {
		return consultPresistence.saveConsult(consult);
	}
	@Override
	public Response setPaymentConsult(Long id) {
		return consultPresistence.updatePaymentConsult(id);
	}
}
