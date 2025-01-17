package com.api.vehicles.aplication.ports.outputs;


import com.api.vehicles.domain.GenerarConsulta;
import com.api.vehicles.domain.Response;

public interface GenerateConsultPersistencePort {
	public GenerarConsulta saveConsult(GenerarConsulta consult);
	public Response updatePaymentConsult(Long id);
}
