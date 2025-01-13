package com.api.vehicles.aplication.ports.inputs;

import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

public interface UploadInformPort {
	public ResponseEntity<?> uploadInform(MultipartFile file, Long id);
}
