package com.accenture.prueba_back.service;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accenture.prueba_back.Entity.FranquiciaEntity;
import com.accenture.prueba_back.Entity.SucursalEntity;
import com.accenture.prueba_back.repository.ISucursalRepository;

@Service
public class SucursalServiceImpl implements ISucursalService {
	private static final Logger log = LoggerFactory.getLogger(SucursalServiceImpl.class);
	
	@Autowired
	private ISucursalRepository sucursalRepository;
	
	@Autowired
	private IFranquiciaService franquiciaService;
	
	public String addSucursal(String nombreFranquicia, String nombreSucursal) {
		log.info("Ingresando a clase SucursalServiceImpl a metodo addSucursal");
		Optional<SucursalEntity> optional = null;
		FranquiciaEntity franquiciaEntity = null;
		
		franquiciaEntity = franquiciaService.verificarExisteFranquicia(nombreFranquicia);
		
		if(franquiciaEntity != null) {
			//Encontrar por nombre sucursal y id franquicia
			optional = sucursalRepository.findByNombreAndFranquiciaId(nombreSucursal, franquiciaEntity.getId());
			
			if(optional.isPresent()) {
				log.info("Ya existe una sucursal con ese nombre: {}", nombreSucursal);
				return "Ya existe una sucursal con ese nombre: " + nombreSucursal;
			}
			SucursalEntity entity = new SucursalEntity();
			entity.setNombre(nombreSucursal);
			entity.setFranquicia(franquiciaEntity);
			
			entity = sucursalRepository.save(entity);
			if(entity.getId() != null) {
				log.info("Se guardo una nueva sucursal con id {}", entity.getId());
				return "Se guardo una nueva sucursal con id " + entity.getId();
			}else {
				return "No se guardo efectivamente la sucursal ingresada";
			}
		}else {
			return "La franquicia ingresada no existe por lo que no se pudo guardar la sucursal";
		}
	}
	
	public String actualizarNombreSucursal(String nombreActual, String nuevoNombre, String nombreFranquicia) {
		SucursalEntity sucursal = verificarExistenciaSucursal(nombreFranquicia, nombreActual);
		
		if(sucursal == null) {
			return "no hay una sucursal con el nombre : " + nombreActual;
		}
		sucursal.setNombre(nuevoNombre);
		sucursalRepository.save(sucursal);
		log.info("Se guardo el nuevo nombre para la sucursal");
		return "La sucursal con el nombre: " + nombreActual + " tiene ahora el nombre de: " + nuevoNombre;
	}
	
	public SucursalEntity verificarExistenciaSucursal(String nombreFranquicia, String nombreSucursal) {
		Optional<SucursalEntity> optional = null;
		FranquiciaEntity franquiciaEntity = null;
		
		franquiciaEntity = franquiciaService.verificarExisteFranquicia(nombreFranquicia);
		
		if(franquiciaEntity == null) {
			return null;
		}else {
			//Encontrar por nombre sucursal y id franquicia
			optional = sucursalRepository.findByNombreAndFranquiciaId(nombreSucursal, franquiciaEntity.getId());
			
			if(optional.isPresent()) {
				return optional.get();
			}else {
				return null;
			}
		}
	}
}
