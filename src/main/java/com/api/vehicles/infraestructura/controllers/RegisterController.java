package com.api.vehicles.infraestructura.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.vehicles.aplication.ports.inputs.RegisterPort;
import com.api.vehicles.domain.Register;
import com.api.vehicles.domain.Response;

@RestController
@RequestMapping("/register")
@CrossOrigin("*")
public class RegisterController {
	@Autowired
	RegisterPort portRegister;
	
	@PostMapping
	public ResponseEntity<Response> registerUser(@RequestBody Register register){
		Register r=portRegister.registerUser(register);
		if(r==null) {
			return new ResponseEntity<Response>(new Response(false, "Ocurrio un error al registrarse.",null),HttpStatus.OK);
		}
		return new ResponseEntity<Response>(new Response(true, "Se registro con exito.",r),HttpStatus.OK);
	}
}
