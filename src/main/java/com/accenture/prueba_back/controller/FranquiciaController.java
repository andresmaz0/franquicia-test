package com.accenture.prueba_back.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.accenture.prueba_back.dto.ActualizarNombre;
import com.accenture.prueba_back.dto.FranquiciaDto;
import com.accenture.prueba_back.service.IFranquiciaService;

@RestController
@RequestMapping("/v1")
public class FranquiciaController {
	private static final Logger log = LoggerFactory.getLogger(FranquiciaController.class);
	
	@Autowired
	private IFranquiciaService franquiciaService;
	
	@CrossOrigin
	@GetMapping(path = "/run/")
	public String testInicial() {
		return "APP franquicias funcionando";
	}
	
	@CrossOrigin
	@PostMapping(path = "/nueva-franquicia")
	public String agregarFranquicia(@RequestBody FranquiciaDto request) {
		log.info("Ingresando a FranquiciaController metodo agregarFranquicia");
		request.setNombreFranquicia(request.getNombreFranquicia().toLowerCase());
		return franquiciaService.addFranquicia(request.getNombreFranquicia()); 
	}
	
	@CrossOrigin
	@PostMapping(path = "/actualizar-nombre-franquicia")
	public String actualizarNombreFranquicia(@RequestBody ActualizarNombre request) {
		log.info("Ingresando a FranquiciaController metodo actualizarNombreFranquicia");
		request.setNombreActual(request.getNombreActual().toLowerCase());
		request.setNuevoNombre(request.getNuevoNombre().toLowerCase());
		return franquiciaService.actualizarNombreFranquicia(request.getNombreActual(), request.getNuevoNombre()); 
	}
}
