package com.accenture.prueba_back.service;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accenture.prueba_back.Entity.FranquiciaEntity;
import com.accenture.prueba_back.repository.IFranquiciaRepository;

@Service
public class FranquiciaServiceImpl implements IFranquiciaService {
	private static final Logger log = LoggerFactory.getLogger(FranquiciaServiceImpl.class);
	
	@Autowired
	private IFranquiciaRepository franquiciaRepository;
	
	public String addFranquicia(String nombre) {
		log.info("Ingresando a clase FranquiciaServiceImpl a metodo addFranquicia");
		Optional<FranquiciaEntity> optional = null;
		
		optional = franquiciaRepository.findByNombre(nombre);
		
		if(optional.isPresent()) {
			log.info("Ya existe una franquicia con ese nombre: {}", nombre);
			return "Ya existe una franquicia con ese nombre: " + nombre;
		}
		FranquiciaEntity entity = new FranquiciaEntity();
		entity.setNombre(nombre);
		
		entity = franquiciaRepository.save(entity);
		if(entity.getId() != null) {
			log.info("Se guardo una nueva franquicia con id {}", entity.getId());
			return "Se guardo una nueva franquicia con id " + entity.getId();
		}else {
			return "No se pudo guardar correctamente la franquicia ingresada";
		}
	}
	
	public FranquiciaEntity verificarExisteFranquicia(String nombre) {
		Optional<FranquiciaEntity> optional = null;
		
		optional = franquiciaRepository.findByNombre(nombre);
		
		if(optional.isPresent()) {
			return optional.get();
		}else {
			return null;
		}
	}
}
