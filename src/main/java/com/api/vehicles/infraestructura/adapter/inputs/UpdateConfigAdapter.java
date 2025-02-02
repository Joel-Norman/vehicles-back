package com.api.vehicles.infraestructura.adapter.inputs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.vehicles.aplication.ports.inputs.UpdateConfigPort;
import com.api.vehicles.aplication.ports.outputs.UpdateConfigPersistencePort;
import com.api.vehicles.domain.Configuration;
import com.api.vehicles.domain.Response;
@Service
public class UpdateConfigAdapter implements UpdateConfigPort{

	@Autowired
	UpdateConfigPersistencePort configPort;
	@Override
	public Response upadateConfig(Configuration config) {
		return configPort.updateConfig(config);
	}
	@Override
	public Response viewConfig() {
		// TODO Auto-generated method stub
		return configPort.viewConfig();
	}

}
