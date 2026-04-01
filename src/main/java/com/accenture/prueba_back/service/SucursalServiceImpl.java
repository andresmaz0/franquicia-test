package com.accenture.prueba_back.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accenture.prueba_back.dao.ISucursalDao;

@Service
public class SucursalServiceImpl implements ISucursalService {
	private static final Logger log = LoggerFactory.getLogger(SucursalServiceImpl.class);
	
	@Autowired
	private ISucursalDao sucursalDao;
	
	public String addSucursal(String nombreFranquicia, String nombreSucursal) {
		log.info("Ingresando a clase SucursalServiceImpl a metodo addSucursal");
		
		boolean procesoAcabado = sucursalDao.agregarSucursal(nombreFranquicia, nombreSucursal);
		String mensaje = null;
		if(procesoAcabado) {
			mensaje = "Se agrego Efectivamente la Sucursal: " + nombreSucursal + " a la franquicia :" + nombreFranquicia;
		}else {
			mensaje = "No se agrego efectivamente la Sucursal: " + nombreSucursal + " a la franquicia :" + nombreFranquicia;
		}
		return mensaje;
	}
}
