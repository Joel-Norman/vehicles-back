package com.api.vehicles.aplication.ports.inputs;

import com.api.vehicles.domain.GenerarConsulta;
import com.api.vehicles.domain.GenerateInform;

public interface GenerateInformPort {
	public GenerateInform generateInform(GenerateInform consult);
}
