package com.api.vehicles.infraestructura.adapter.inputs;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.api.vehicles.aplication.ports.inputs.UploadInformPort;
import com.api.vehicles.domain.Response;
import com.api.vehicles.infraestructura.adapter.outputs.entities.ConsultEntity;
import com.api.vehicles.infraestructura.adapter.outputs.repositories.ConsultEntityRepository;
@Service
public class UploadInformAdapter implements UploadInformPort {
	@Autowired
    ConsultEntityRepository consultRepo;
	@Override
	public ResponseEntity<?> uploadInform(MultipartFile file, Long id) {
		try {
        	ConsultEntity c=consultRepo.findById(id).get();
			
            Path filePath = Paths.get(id+"-inform-"+file.getOriginalFilename());
            String archive=id+"-inform-"+file.getOriginalFilename();
            Files.copy(file.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);
            c.setInform(archive);
            c.setStatus("AVAILABLE");
            consultRepo.save(c);
            
            return new ResponseEntity(new Response(true,"Informe guardado con exito.",null),HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity(new Response(true,"Ocurrio un error al intentar guardar el informe.",null),HttpStatus.OK);
        }
	}

}
