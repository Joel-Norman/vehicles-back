package com.api.vehicles.aplication.ports.outputs;

import com.api.vehicles.domain.Configuration;
import com.api.vehicles.domain.Response;

public interface UpdateConfigPersistencePort {
	public Response updateConfig(Configuration config);
	public Response viewConfig();
}
