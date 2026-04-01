package com.accenture.prueba_back.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.accenture.prueba_back.dto.SucursalDto;
import com.accenture.prueba_back.service.ISucursalService;

@RestController
@RequestMapping("/v1")
public class SucursalController {
	private static final Logger log = LoggerFactory.getLogger(SucursalController.class);
	
	@Autowired
	private ISucursalService sucursalService;
	
	@CrossOrigin
	@PostMapping(path = "/nueva-sucursal")
	public String agregarSucursal(@RequestBody SucursalDto request) {
		log.info("Ingresando a SucursalController metodo agregarSucursal");
		request.setNombre(request.getNombre().toLowerCase());
		request.setNombreFranquicia(request.getNombreFranquicia().toLowerCase());
		return sucursalService.addSucursal(request.getNombreFranquicia(), request.getNombre()); 
	}
}
