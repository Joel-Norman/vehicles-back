package com.api.vehicles.infraestructura.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.api.vehicles.aplication.ports.inputs.UpdateConfigPort;
import com.api.vehicles.domain.Configuration;
import com.api.vehicles.domain.Response;

@RestController
@RequestMapping("/config")
@CrossOrigin("*")
public class ConfigurationController {
	@Autowired
	UpdateConfigPort configAdapter;
	@GetMapping()
	public ResponseEntity<?> viewConfig(){
		System.out.println("entro");
		return new ResponseEntity<Response>(configAdapter.viewConfig(),HttpStatus.OK);
	}
	@PostMapping()
    public ResponseEntity<?> updateConfig(@RequestBody Configuration conf) {
		return new ResponseEntity<Response>(configAdapter.upadateConfig(conf),HttpStatus.OK);
    }
}
