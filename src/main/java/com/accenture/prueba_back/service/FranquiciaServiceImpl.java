package com.accenture.prueba_back.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accenture.prueba_back.dao.IFranquiciaDao;

@Service
public class FranquiciaServiceImpl implements IFranquiciaService {
	private static final Logger log = LoggerFactory.getLogger(FranquiciaServiceImpl.class);
	
	@Autowired
	private IFranquiciaDao franquiciaDao;
	
	public String addFranquicia(String nombre) {
		log.info("Ingresando a clase FranquiciaServiceImpl a metodo addFranquicia");
		franquiciaDao.agregarFranquicia(nombre);
		return null;
	}
}
