package com.api.vehicles.aplication.ports.inputs;


import com.api.vehicles.domain.GenerarConsulta;
import com.api.vehicles.domain.Response;

public interface GenerarConsultaPort {
	public GenerarConsulta generateCOnsult(GenerarConsulta consult);
	public Response setPaymentConsult(Long id);
}
