package com.api.vehicles.infraestructura.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.vehicles.aplication.ports.inputs.LoginPort;
import com.api.vehicles.domain.Login;
import com.api.vehicles.domain.Response;
import com.api.vehicles.domain.Session;

@RestController
@RequestMapping("/login")
@CrossOrigin("*")
public class LoginController {
	@Autowired
	LoginPort portLogin;
	
	@PostMapping
	public ResponseEntity<Response> loginUser(@RequestBody Login login){
		Session s=portLogin.loginUser(login);
		if(s==null) {
			return new ResponseEntity<Response>(new Response(false, "Email y contraseña incorrectos.",null),HttpStatus.OK);
		}
		return new ResponseEntity<Response>(new Response(true, "Bienvenido!!",s),HttpStatus.OK);
	}
}
