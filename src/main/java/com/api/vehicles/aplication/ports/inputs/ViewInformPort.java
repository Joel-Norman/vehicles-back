package com.api.vehicles.aplication.ports.inputs;

import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;

public interface ViewInformPort {
	public ResponseEntity<?> viewInform(String archivo);
}
