package com.api.vehicles.infraestructura.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.vehicles.aplication.ports.inputs.GenerarConsultaPort;
import com.api.vehicles.aplication.ports.inputs.ListConsultPort;
import com.api.vehicles.domain.GenerarConsulta;
import com.api.vehicles.domain.Response;

@RestController
@RequestMapping("/consult")
@CrossOrigin("*")
public class GenerarConsultaController {
	@Autowired
	GenerarConsultaPort portGenerar;
	@Autowired
	ListConsultPort portList;
	
	@PostMapping
	public ResponseEntity<Response> generateCOnsult(@RequestBody GenerarConsulta consult){
		GenerarConsulta r=portGenerar.generateCOnsult(consult);
		if(r==null) {
			return new ResponseEntity<Response>(new Response(false, "Ocurrio un error al generar su consulta.",null),HttpStatus.OK);
		}
		return new ResponseEntity<Response>(new Response(true, "Su consulta fue generada con exito, por favor espere a que este disponible.",r),HttpStatus.OK);
	}
	@GetMapping("/pendient")
	public ResponseEntity<Response> listConsultPendient(){
		return new ResponseEntity<Response>(new Response(true, "",portList.listConsultPendient("NOT_AVAILABLE")),HttpStatus.OK);
	}
	@GetMapping("/{username}")
	public ResponseEntity<Response> generateCOnsult(@PathVariable String username){
		return new ResponseEntity<Response>(new Response(true, "",portList.listConsult(username)),HttpStatus.OK);
	}
}
