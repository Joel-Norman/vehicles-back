package com.api.vehicles.aplication.ports.inputs;


import com.api.vehicles.domain.Configuration;
import com.api.vehicles.domain.Response;

public interface UpdateConfigPort {
	public Response upadateConfig(Configuration conf);
	public Response viewConfig();
}
