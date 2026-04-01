package com.accenture.prueba_back.dao;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.accenture.prueba_back.Entity.FranquiciaEntity;
import com.accenture.prueba_back.Entity.SucursalEntity;
import com.accenture.prueba_back.repository.ISucursalRepository;

@Repository
public class SucursalDaoImpl implements ISucursalDao{


	private static final Logger log = LoggerFactory.getLogger(FranquiciaDaoImpl.class);
	
	@Autowired
	private ISucursalRepository sucursalRepository;
	
	@Autowired
	private IFranquiciaDao franquiciaDao;
	
	public Boolean agregarSucursal(String nombreFranquicia, String nombreSucursal) {
		Optional<SucursalEntity> optional = null;
		FranquiciaEntity franquiciaEntity = null;
		
		franquiciaEntity = franquiciaDao.verificarExisteFranquicia(nombreFranquicia);
		
		if(franquiciaEntity != null) {
			//Encontrar por nombre sucursal y id franquicia
			optional = sucursalRepository.findByNombreAndFranquiciaId(nombreSucursal, franquiciaEntity.getId());
			
			if(optional.isPresent()) {
				log.info("Ya existe una sucursal con ese nombre: {}", nombreSucursal);
				return false;
			}
			SucursalEntity entity = new SucursalEntity();
			entity.setNombre(nombreSucursal);
			entity.setFranquicia(franquiciaEntity);
			
			entity = sucursalRepository.save(entity);
			if(entity.getId() != null) {
				log.info("Se guardo una nueva sucursal con id {}", entity.getId());
				return true;
			}else {
				return false;
			}
		}else {
			return false;
		}
	}
}
