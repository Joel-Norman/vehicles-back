package com.api.vehicles.infraestructura.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.api.vehicles.aplication.ports.inputs.AdsPort;
import com.api.vehicles.domain.Response;

@RestController
@RequestMapping("/ads")
@CrossOrigin("*")
public class AdsController {
	@Autowired
	AdsPort adsPort;
	
	@GetMapping()
	public ResponseEntity<?> listAds(){
		System.out.println("entro");
		return new ResponseEntity<Response>(adsPort.listAds(),HttpStatus.OK);
	}
	@PostMapping("")
    public ResponseEntity<?> newAds(
    		@RequestParam("url") String url,
    		@RequestParam("file") MultipartFile file,
    		@RequestParam("title") String title) {
		return new ResponseEntity<Response>(adsPort.addAds(file, url,title),HttpStatus.OK);
    }
	@PutMapping("/{id}")
	public ResponseEntity<?> updateAds(
			@PathVariable("id") Long id,
			@RequestParam("file") MultipartFile file,
			@RequestParam("url") String url,
			@RequestParam("title") String title,
			@RequestParam("image") boolean image){
		System.out.println("entro");
		return new ResponseEntity<Response>(adsPort.updateAds(file, url, id, image,title),HttpStatus.OK);
	}
	@DeleteMapping("/{id}")
    public ResponseEntity<?> deleteAds(@PathVariable Long id) {
		return new ResponseEntity<Response>(adsPort.deleteAds(id),HttpStatus.OK);
    }
}
