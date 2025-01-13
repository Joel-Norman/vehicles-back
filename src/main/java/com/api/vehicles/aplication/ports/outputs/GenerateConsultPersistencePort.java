package com.api.vehicles.aplication.ports.outputs;

import com.api.vehicles.domain.GenerarConsulta;

public interface GenerateConsultPersistencePort {
	public GenerarConsulta saveConsult(GenerarConsulta consult);
}
