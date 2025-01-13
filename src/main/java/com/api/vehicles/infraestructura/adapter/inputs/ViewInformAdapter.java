package com.api.vehicles.infraestructura.adapter.inputs;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.MediaType;

import org.springframework.http.HttpHeaders;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;





import com.api.vehicles.aplication.ports.inputs.ViewInformPort;
@Service
public class ViewInformAdapter implements ViewInformPort {

	@Override
	public ResponseEntity<?> viewInform(String archivo) {
		try {
			System.out.println(archivo);
            Path file = Paths.get(archivo);
            Resource resource = new UrlResource(file.toUri());
            if (resource.exists() && resource.isReadable()) {
            	System.out.println("entro2");
                String contentType = Files.probeContentType(file);
                System.out.println("entro3");
                System.out.println(contentType);
                return ResponseEntity.ok()
                        .contentType(MediaType.parseMediaType(contentType != null ? contentType : "application/octet-stream"))
                        .header(HttpHeaders.CONTENT_DISPOSITION, "inline; filename=\"" + resource.getFilename() + "\"")
                        .body(resource.getContentAsByteArray());
            } else {
            	System.out.println("entro4");
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.internalServerError().build();
        }
	}

}
