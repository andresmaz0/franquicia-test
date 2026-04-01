package com.accenture.prueba_back.dao;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.accenture.prueba_back.Entity.FranquiciaEntity;
import com.accenture.prueba_back.repository.IFranquiciaRepository;

@Repository
public class FranquiciaDaoImpl implements IFranquiciaDao{

	private static final Logger log = LoggerFactory.getLogger(FranquiciaDaoImpl.class);
	
	@Autowired
	private IFranquiciaRepository franquiciaRepository;
	
	public Boolean agregarFranquicia(String nombre) {
		Optional<FranquiciaEntity> optional = null;
		
		optional = franquiciaRepository.findByNombre(nombre);
		
		if(optional.isPresent()) {
			log.info("Ya existe una franquicia con ese nombre: {}", nombre);
			return false;
		}
		FranquiciaEntity entity = new FranquiciaEntity();
		entity.setNombre(nombre);
		
		entity = franquiciaRepository.save(entity);
		if(entity.getId() != null) {
			log.info("Se guardo una nueva franquicia con id {}", entity.getId());
			return true;
		}else {
			return false;
		}
	}
}
