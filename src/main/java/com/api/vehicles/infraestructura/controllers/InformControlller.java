package com.api.vehicles.infraestructura.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.api.vehicles.aplication.ports.inputs.UploadInformPort;
import com.api.vehicles.aplication.ports.inputs.ViewInformPort;
@RestController
@RequestMapping("/inform")
@CrossOrigin("*")
public class InformControlller {
	@Autowired
	ViewInformPort portInform;
	@Autowired
	UploadInformPort portUpload;
	@GetMapping("/{archivo}")
	public ResponseEntity<?> registerUser(@PathVariable String archivo){
		System.out.println("entro");
		return portInform.viewInform(archivo);
	}
	@PostMapping("/upload/{id}")
    public ResponseEntity<?> uploadInform(@RequestParam("file") MultipartFile file,@PathVariable Long id) {
        return portUpload.uploadInform(file, id);
    }
}
