package com.api.vehicles.infraestructura.controllers;

import java.io.FileWriter;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.api.vehicles.aplication.ports.inputs.ProcessPaymentApiPort;
import com.api.vehicles.domain.ProcessPayment;
import com.api.vehicles.domain.Response;
import com.api.vehicles.domain.ResponsePayment;

@RestController
@RequestMapping("/payment")
@CrossOrigin("*")
public class ProcessPaymentController {
	@Autowired
	ProcessPaymentApiPort portPayment;
	@PostMapping("/{id}")
	public ResponseEntity<Response> processPayment(@RequestBody ProcessPayment payment,@PathVariable Long id){
		ResponsePayment s=portPayment.processPaymentApi(payment,id);
		if(s==null) {
			return new ResponseEntity<Response>(new Response(false, "No se pudo procesar su pago",null),HttpStatus.OK);
		}
		return new ResponseEntity<Response>(new Response(true, "",s),HttpStatus.OK);
	}
	@GetMapping()
	public ResponseEntity<Response> processPaymentResponse(@RequestParam int code,@RequestParam String auth,@RequestParam String order){
		System.out.println(code+" "+ auth+" "+ order);
		try {
            // Crear el FileWriter
            FileWriter escritor = new FileWriter("respuesta.txt");

            // Escribir el contenido
            escritor.write(code+" "+ auth+" "+ order);

            // Cerrar el escritor
            escritor.close();

            
        } catch (IOException e) {
            System.out.println("Ocurrió un error al guardar el archivo.");
            e.printStackTrace();
        }
		return new ResponseEntity<Response>(new Response(true, "",null),HttpStatus.OK);
	}
}
